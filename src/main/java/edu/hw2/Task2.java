package edu.hw2;

public final class Task2 {

    private Task2() {

    }

    public static class Rectangle {
        private final int width;
        private final int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle() {
            this.width = 0;
            this.height = 0;
        }

        Rectangle setWidth(int width) {
            return new Rectangle(width, height);
        }

        Rectangle setHeight(int height) {
            return new Rectangle(width, height);
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {

        public Square(int size) {
            super(size, size);
        }

        public Square() {
            super(0, 0);
        }

        @Override
        Rectangle setWidth(int width) {
            return super.setWidth(width);
        }

        @Override
        Rectangle setHeight(int height) {
            return super.setHeight(height);
        }

        Square setSize(int size) {
            return new Square(size);
        }
    }
}
