package lifegame;

public class Logic {
	private int row;// 行
	private int col;// 列
	protected Map lifeMap;

	public Logic(int r, int c) {
		row = r;// 行
		col = c;// 列
		lifeMap = new Map(row, col);
	}

	public Map GetMap() {
		return lifeMap;
	}

	// 随机生成地图
	public void InitMap() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				double x = Math.random();
				if (x > 0.5) {
					lifeMap.setNewMap(i, j, true);
				} else {
					lifeMap.setNewMap(i, j, false);
				}
			}
		}
		lifeMap.updateMap();
	}

	// 更新下一代
	public void UpdateNext() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int num = lifeMap.getVertice(i - 1, j - 1) + lifeMap.getVertice(i - 1, j)
						+ lifeMap.getVertice(i - 1, j + 1) + lifeMap.getVertice(i, j - 1) + lifeMap.getVertice(i, j + 1)
						+ lifeMap.getVertice(i + 1, j - 1) + lifeMap.getVertice(i + 1, j)
						+ lifeMap.getVertice(i + 1, j + 1);

				// 判断
				if (lifeMap.getVertice(i, j) == 1) {// 生
					if (num < 2 || num > 3)
						lifeMap.setNewMap(i, j, false);
					else
						lifeMap.setNewMap(i, j, true);
				} else {// 死
					if (num == 3)
						lifeMap.setNewMap(i, j, true);
					else
						lifeMap.setNewMap(i, j, false);
				}

				// if(i>0&&i<9) {
				// if(j>0&&j<9) {
				// //全判断
				//
				// }else if(j==0){
				//
				// }else {
				//
				// }
				// }else {
				// if(j==0) {
				//
				// }else if(j==9) {
				//
				// }else {
				// if(i==0) {
				//
				// }else {
				//
				// }
				// }
				// }
			}
		}
		lifeMap.updateMap();
	}

	// public void startGame() {
	// InitMap();
	// for (int i = 0; i < 100; i++) {
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// UpdateNext();
	// }
	// }
}
