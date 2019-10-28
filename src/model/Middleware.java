package model;

public abstract class Middleware {
    private Middleware nextProcess;
    protected boolean processStatus;

    public void setNextProcess(Middleware nextProcess) {
        this.nextProcess = nextProcess;
    }

    protected abstract boolean checkAuthentication();

    public boolean checkNextMiddleware() {
        this.processStatus = checkAuthentication();

        if (nextProcess == null) {
            return processStatus;
        }

        return nextProcess.checkNextMiddleware();
    }
}