package laboratory0;

public class Car {
    float speed = 0;
    boolean isMoving = false;
    public void stop() {
        this.isMoving = false;
    }
    public void accelerate(float amount) {
        this.speed = this.speed + amount;
        this.isMoving = this.speed != 0;
    }
    public void printSpeed() {
        System.out.println("Speed: " + this.speed);
    }
    public void printIsMoving() {
        if(this.isMoving) {
            System.out.println("The car is moving");
        } else {
            System.out.println("The car is not moving");
        }
    }
}
