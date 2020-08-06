package tf.nick.hypertrash.functional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

class ChainOfResponsibilityDemo {
    static final RequestHandler WRAP_IN_TRANSACTION_TAG =
        req -> new Request(String.format("<transaction>%s</transaction>", req.getData()));

    static final RequestHandler CREATE_DIGEST =
        req -> {
            String digest = "";
            try {
                final MessageDigest md5 = MessageDigest.getInstance("MD5");
                final byte[] digestBytes = md5.digest(req.getData().getBytes(StandardCharsets.UTF_8));
                digest = new String(Base64.getEncoder().encode(digestBytes));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return new Request(req.getData() + String.format("<digest>%s</digest>", digest));
        };

    static final RequestHandler WRAP_IN_REQUEST_TAG =
        req -> new Request(String.format("<request>%s</request>", req.getData()));

    static final RequestHandler COMMON_REQUEST_HANDLER =
        WRAP_IN_TRANSACTION_TAG.setSuccessor(CREATE_DIGEST.setSuccessor(WRAP_IN_REQUEST_TAG));

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String requestData = scanner.nextLine();
        final Request notCompletedRequest = new Request(requestData);

        System.out.println(COMMON_REQUEST_HANDLER.handle(notCompletedRequest).getData());
    }

    @FunctionalInterface
    interface RequestHandler {
        Request handle(Request request);

        default RequestHandler setSuccessor(RequestHandler requestHandler) {
            return req -> requestHandler.handle(this.handle(req));
        }
    }

    static class Request {
        private final String data;

        public Request(String requestData) {
            this.data = requestData;
        }

        public String getData() {
            return data;
        }
    }
}
