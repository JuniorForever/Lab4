public class Fork {
    boolean state;
    boolean isTaken() {
        return state;
    }
    void setState(boolean state) {
        this.state = state;
    }
    Fork(){
        state = false;
    }
}
