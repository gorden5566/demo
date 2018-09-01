package com.gorden5566;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gorden5566
 * @date
 */
public class Perceptron {
    public static void main(String[] args) {
        // 训练样本初始化
        List<Example> trainingSet = getTrainingSet();

        // 参数初始化
        W w = new W(0, 0);
        B b = new B(0);

        // 学习率
        int eta = 1;

        int count = 0;
        // 是否有误分类
        for (int i = 0; i < 1000; i++) {
            boolean hasMisClassification = false;
            for (Example example : trainingSet) {
                // 误分类时更新参数
                if (calcDistance(example, w, b) <= 0) {
                    count++;
                    hasMisClassification = true;
                    // 输出样本和参数
                    System.out.println("第" + count + "次更新，样本：" + example + ", 参数：" + w + ", " + b);
                    updateParameters(example, w, b, eta);
                    System.out.println("第" + count + "次更新后，参数：" + w + ", " + b);
                }
            }

            // 全部分类正确
            if (!hasMisClassification) {
                break;
            }
        }

        System.out.println("训练结果：" + w + ", " + b);
    }

    /**
     * 计算距离
     * distance <= 0, 则分类结果错误
     * distance > 0, 则分类结果正确
     *
     * @param example
     * @param w
     * @param b
     * @return
     */
    private static int calcDistance(Example example, W w, B b) {
        int wx = w.getW1() * example.getX1() + w.getW2() * example.getX2();
        int distance = example.getY() * (wx + b.getB());
        return distance;
    }

    /**
     * 更新参数
     *
     * @param example
     * @param w
     * @param b
     * @param eta
     */
    private static void updateParameters(Example example, W w, B b, int eta) {
        // wi = wi + eta * y * xi
        int w1 = w.getW1() + eta * example.getY() * example.getX1();
        int w2 = w.getW2() + eta * example.getY() * example.getX2();
        w.setW1(w1);
        w.setW2(w2);

        // b = b + eta * y
        b.setB(b.getB() + eta * example.getY());
    }

    /**
     * 获取训练样本
     *
     * @return
     */
    private static List<Example> getTrainingSet() {
        List<Example> trainingSet = new ArrayList<>();
        Example example1 = new Example(3, 3, 1);
        Example example2 = new Example(4, 3, 1);
        Example example3 = new Example(1, 1, -1);
        trainingSet.add(example1);
        trainingSet.add(example2);
        trainingSet.add(example3);

        return trainingSet;
    }

    /**
     * 参数w
     */
    public static class W {
        private int w1;
        private int w2;

        public W(int w1, int w2) {
            this.w1 = w1;
            this.w2 = w2;
        }

        public int getW1() {
            return w1;
        }

        public void setW1(int w1) {
            this.w1 = w1;
        }

        public int getW2() {
            return w2;
        }

        public void setW2(int w2) {
            this.w2 = w2;
        }

        @Override
        public String toString() {
            return "W{" +
                "w1=" + w1 +
                ", w2=" + w2 +
                '}';
        }
    }

    public static class B {
        private int b;

        public B(int b) {
            this.b = b;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "B{" +
                "b=" + b +
                '}';
        }
    }

    /**
     * 训练样本
     */
    public static class Example {
        /**
         * 输入
         */
        private int x1;
        private int x2;

        /**
         * 输出，又叫做标记
         */
        private int y;

        public Example(int x1, int x2, int y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        public int getX1() {
            return x1;
        }

        public int getX2() {
            return x2;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Example{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y=" + y +
                '}';
        }
    }
}
