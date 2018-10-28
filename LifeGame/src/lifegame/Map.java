package lifegame;

public class Map {
	private int row; // 行
	private int col; // 列
	private Boolean oldMap[][];
	private Boolean newMap[][];

	public Map(int r,int c) {
		row=r;// 行
		col=c;// 列
		oldMap= new Boolean[row][col];
		newMap= new Boolean[row][col];
	}
	
	// 初始化地图
	// public void initMap() {
	// for(int i=0;i<row;i++)
	// for(int j=0;j<col;j++)
	// oldMap[i][j]=false;
	// for(int i=0;i<row;i++)
	// for(int j=0;j<col;j++)
	// newMap[i][j]=false;
	// }

	// 获取点信息
	public int getVertice(int i, int j) {
		//超出范围记为0
		if (i < 0 || j < 0 || i >= row || j >= col)
			return 0;
		if (oldMap[i][j] == true) {
			return 1;
		} else {
			return 0;
		}
	}

	// 更新下一个状态
	public void setNewMap(int i, int j, Boolean newVertice) {
		newMap[i][j] = newVertice;
	}

	// 更新图
	public void updateMap() {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				oldMap[i][j] = newMap[i][j];
	}
}
