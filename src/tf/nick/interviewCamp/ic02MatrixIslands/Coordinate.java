package tf.nick.interviewCamp.ic02MatrixIslands;

import java.util.Objects;

class Coordinate {
  private final int row;
  private final int column;

  public Coordinate(int row, int column) {
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
    Coordinate that = (Coordinate) o;
    return row == that.row &&
            column == that.column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, column);
  }
}
