# ボトル（水筒）で学ぶOOP

## 1. Bottleクラスの実装

Bottleクラスを作成してオブジェクト指向について学習します。Bottleクラスにはフタが空いているかを示す状態openedと水の量を示すamountフィールドがあります。またdrainメソッドで水を飲むことができます。

+ Bottle.java
+ Main.java

### Bottle.java

```java
public class Bottle {

	private boolean opened;
	private int amount;

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int drain() {
		if (opened == false) {
			System.err.println("Bottle is closed.");
			return 0;
		}
		if (amount == 0) {
			System.err.println("Bottle is empty.");
			return 0;
		}
		amount--;
		return 1;
	}
}
```

### Main.java

```java
public class Main {
	public static void main(String[] args) {
		Bottle bottle = new Bottle();
		bottle.setOpened(true);
		bottle.setAmount(3);
		for (int i = 0; i < 5; i++) {
			int water = bottle.drain();
			System.out.println("Water: " + water);
		}
	}
}
```

### 実行結果

```
Water: 1
Water: 1
Water: 1
Water: 0
Water: 0
Bottle is empty.
Bottle is empty.
```

### 課題1

コンストラクタでフィールド（opened, amount）を初期化できるように修正してください。

### 課題2

System.out.println、System.err.printlnの違いについて考察してください。

---

## 2.Humanクラスの実装

続いてHumanクラスを作成します。HumanクラスをBottleを使って水を飲むことができます。

+ Human.java
+ Bottle.java（変更なし）
+ Main.java（修正）

### Human.java

```java
public class Human {
	private String name;

	public Human(String name) {
		this.name = name;
	}

	public void drink(Bottle bottle) {
		int water = bottle.drain();
		System.out.println(name + " drink : " + water);
	}
}
```

### Main.java

```java
public class Main {
	public static void main(String[] args) {
		Bottle bottle = new Bottle(true, 3);
		Human john = new Human("John");
		for (int i = 0; i < 5; i++) {
			john.drink(bottle);
		}
	}
}
```

### 実行結果

```java
John drink : 1
John drink : 1　
John drink : 1
John drink : 0
John drink : 0
Bottle is empty.
Bottle is empty.
```

### 課題3

Humanクラスにbottleフィールドを追加し、setBottleメソッドを追加します。それからdrinkメソッドの引数bottleを削除しましょう。

> drinkメソッドの引数ではなくフィールドでbottleを管理します。

### 課題4

HumanクラスにopenBottleメソッドを追加しましょう。

---

## 3.MyThrowableインタフェースの実装

新たにMyThrowableインタフェースとBallクラスを追加します。HumanはBallを投げることができます。

+ MyThrowable.java
+ Ball.java
+ Human.java
+ Main.java

### MyThrowable.java

```java
public interface MyThrowable {
	public void myThrow();
}
```

### Ball.java

```java
public class Ball implements MyThrowable {
	public void myThrow() {
		System.out.print("Ball: ");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("o");
		}
		System.out.println();		
	}
}
```

### Human.java

```java
public class Human {
	private String name;

	public Human(String name) {
		this.name = name;
	}

	public void drink(Bottle bottle) {
		int water = bottle.drain();
		System.out.println(name + " drink : " + water);
	}

	public void throw2(MyThrowable throwable) {
		throwable.myThrow();
	}
}
```

> throw2メソッドを追記します。

### Main.java

```java
public class Main {
	public static void main(String[] args) {
		Human john = new Human("John");
		Ball ball = new Ball();
		john.throw2(ball);

    // Bottle bottle = new Bottle(true, 3);
    // john.throw2(bottle)
	}
}
```

### 実行結果

```
Ball: oooooooooo
```

### 課題5

Bottleクラスもthrow2メソッドで投げれるように修正してください。
