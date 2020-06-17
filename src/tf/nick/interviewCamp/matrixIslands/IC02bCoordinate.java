package tf.nick.interviewCamp.matrixIslands;

import java.util.Objects;

class IC02bCoordinate {
  private final int row;
  private final int column;

  public IC02bCoordinate(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IC02bCoordinate that = (IC02bCoordinate) o;
    return row == that.row &&
            column == that.column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, column);
  }
}