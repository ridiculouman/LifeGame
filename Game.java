package lifegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int sx = 50; // 初始宽度
	private static final int sy = 50; // 初始高度
	private static final int w = 40; // 小方格边长
	private static final int rw = 400; // 方格总边长

	private int row = 10;// 行
	private int col = 10;// 列

	private Logic logic;
	private Graphics jg;

	public Game() {
		logic = new Logic(row, col);

		// 设置界面
		setBounds(100, 100, 500, 500);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 设置背景
		Container p = getContentPane();
		Color rectColor = new Color(0xf5f5f5);
		p.setBackground(rectColor);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 获取专门用于在窗口界面上绘图的图像
		jg = this.getGraphics();

		// // 绘制游戏区域
		// paintComponents(jg);
	}

	// public void paintComponents(Graphics g) {
	// try {
	//
	// // 设置线条颜色为红色
	// g.setColor(Color.red);
	//
	// // 绘制外层矩形框
	// g.drawRect(sx, sy, rw, rw);
	//
	// /*
	// * 绘制水平10个，垂直10个方格。 即水平方向九条线，竖直方向九条线， 外围四周四条线已经画过了，不需要再画。
	// */
	// for (int i = 1; i < 10; i++) {
	// // 绘制第i条竖直线
	// g.drawLine(sx + (i * w), sy, sx + (i * w), sy + rw);
	//
	// // 绘制第i条水平线
	// g.drawLine(sx, sy + (i * w), sx + rw, sy + (i * w));
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// }
	//
	// // 初始化地图
	// logic.InitMap();
	// for (int i = 0; i < 10; i++) {
	// for (int j = 0; j < 10; j++) {
	// if (logic.GetMap().getVertice(i, j) == 1) {
	// setGrid(i, j, Color.RED);
	// }
	// }
	// }
	//
	// for (int k = 0; k < 100; k++) {
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// logic.UpdateNext();
	//
	// for (int i = 0; i < 10; i++) {
	// for (int j = 0; j < 10; j++) {
	// if (logic.GetMap().getVertice(i, j) == 1) {
	// setGrid(i, j, Color.RED);
	// } else {
	// setGrid(i, j, Color.WHITE);
	// }
	// }
	// }
	// }
	// }

	public void setGrid(int cx, int cy, Color color) {
		// 将绘图对象设置为灰色
		jg.setColor(color);

		// 给方格填充颜色
		jg.fillRect(sx + (cx * w) + 1, sy + (cy * w) + 1, w - 2, w - 2);
	}

	public void drawLine() {
		try {
			// 设置线条颜色为红色
			jg.setColor(Color.red);

			// 绘制外层矩形框
			jg.drawRect(sx, sy, rw, rw);

			/*
			 * 绘制水平10个，垂直10个方格。 即水平方向九条线，竖直方向九条线， 外围四周四条线已经画过了，不需要再画。
			 */
			for (int i = 1; i < 10; i++) {
				// 绘制第i条竖直线
				jg.drawLine(sx + (i * w), sy, sx + (i * w), sy + rw);
				// 绘制第i条水平线
				jg.drawLine(sx, sy + (i * w), sx + rw, sy + (i * w));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		// 初始化地图
		logic.InitMap();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (logic.GetMap().getVertice(i, j) == 1) {
					setGrid(i, j, Color.RED);
				}
			}
		}

		// 更新游戏区域并重绘
		for (int k = 0; k < 100; k++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logic.UpdateNext();

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (logic.GetMap().getVertice(i, j) == 1) {
						setGrid(i, j, Color.RED);
					} else {
						setGrid(i, j, Color.WHITE);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.drawLine();
		game.start();
	}
}
