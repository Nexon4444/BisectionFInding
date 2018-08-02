package BisectionSoluter;

public class Result {
    Double solution;
    boolean isOverLimit;

    public Result(Double solution, boolean isOverLimit) {
        this.solution = solution;
        this.isOverLimit = isOverLimit;
    }

    public Double getSolution() {
        return solution;
    }

    public void setSolution(Double solution) {
        this.solution = solution;
    }

    public boolean isOverLimit() {
        return isOverLimit;
    }

    public void setOverLimit(boolean overLimit) {
        isOverLimit = overLimit;
    }
}
