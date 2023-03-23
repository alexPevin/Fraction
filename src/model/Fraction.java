package model;

import java.util.Objects;

public class Fraction implements Comparable<Fraction>{
    private int a;
    private int b;

    public Fraction() {
        this.b = 1;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Fraction(Fraction fraction) {
        a = fraction.a;
        b = fraction.b;
    }

    public Fraction(int b) {
        this.b = b;
    }

    public Fraction(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Знаменатель не может равняться нулю!");
        }
        this.a = a;
        this.b = b;
        reduce();
    }

    public Fraction(String str) {
        String[] array = str.split(" ");
        if (array.length > 0) {
            this.a = Integer.parseInt(array[0]);
        }
        if (array.length > 1) {
            int b = Integer.parseInt(array[1]);
            if (b == 0) {
                throw new ArithmeticException("Знаменатель не может равняться нулю!");
            }
            this.b = b;
        }
    }

    private void reduce() {
        int c = nod(this.a, this.b);
        this.a /= c;
        this.b /= c;
        if (this.b < 0) {
            this.a *= -1;
            this.b *= -1;
        }
    }

    private int nod(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = a; i >= 2; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    //a/b + c/d = (a*d + b*c)/(b*d)
    public Fraction sum(Fraction fraction) {
        // int i = (this.a * fraction.b + this.b * fraction.a) / (this.b * fraction.b);
        int a = this.a * fraction.b + this.b * fraction.a;
        int b = this.b * fraction.b;
        return new Fraction(a, b);
    }

    public Fraction sum(int i) {
        return new Fraction(this.a + this.b * i, this.b);
    }

    public double sum(double i) {
        return (double) this.a / this.b + i;
    }

    public void ownSum(Fraction fraction) {
        Fraction sum = this.sum(fraction);
        this.a = sum.a;
        this.b = sum.b;
    }

    public Fraction subtraction(Fraction fraction) {
        int a = this.a * fraction.b - this.b * fraction.a;
        int b = this.b * fraction.b;
        return new Fraction(a, b);
    }

    public Fraction subtraction(int i) {
        return new Fraction(this.a - this.b * i, this.b);
    }

    public double subtraction(double i) {
        return (double) this.a / this.b - i;
    }

    public Fraction multiplication(Fraction fraction) {
        int a = this.a * fraction.a;
        int b = this.b * fraction.b;
        return new Fraction(a, b);
    }

    public Fraction multiplication(int i) {
        return new Fraction(this.a * i, this.b);
    }

    public double multiplication(double i) {
        return (double) this.a / this.b * i;
    }

    public Fraction reverse() {
        return new Fraction(this.b, this.a);
    }

    public Fraction division(Fraction fraction) {
        return this.multiplication(fraction.reverse());
    }

    @Override
    public int compareTo(Fraction o) {
        Fraction result = this.subtraction(o);
        return result.a;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return a == fraction.a && b == fraction.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        if (a != 0 && b != 0) {
            return "Fraction{" + a + "/" + b + "}";
        }
        if (a == 0) {
            return "Fraction{" + "0" + "}";
        }
        if (b == 1) {
            return " a=" + a;
        }
        return null;
    }

    public static Fraction sum(Fraction[] fractions) {
        Fraction summa = new Fraction();
        for (Fraction fraction : fractions) {
            if (fraction != null)
                summa = summa.sum(fraction);
        }
        return summa;
    }

    public static Fraction maxFraction(Fraction[] fractions) {
        if (fractions.length == 0) {
            return null;
        }
        Fraction res = null;
        int i = 0;
        while (res == null && i != fractions.length) {
            res = fractions[i++];
        }
        if (res != null) {
            for (int j = i; j < fractions.length; j++) {
                Fraction fraction = fractions[j];
                if (fraction != null) {
                    int sort = res.compareTo(fraction);
                    if (sort <= 0) {
                        res = fraction;
                    }
                }
            }
        }
        return res;
    }

    public static int compare(Fraction o1, Fraction o2) {
        if (o1 == null)
            return -1;
        else if (o2 == null)
            return 1;
        return o1.subtraction(o2).a;
    }
}
