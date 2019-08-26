package blackAndWhite;
import java.util.Random;
public class Role {
	private int[][] board = new int[10][10];
	
	public Role() {
		Random ran = new Random();
		for(int i = 0 ; i < 7 ;)
		{
			int tmp1,tmp2;
			tmp1 = ran.nextInt(10);
			tmp2 = ran.nextInt(10);
			if((tmp1 < 4 || tmp1 > 5) && (tmp2 < 4 || tmp2 > 5))
			{
				board[tmp1][tmp2] = 1;
				++i;
			}
		}
		setBoard(4, 4, 2);
		setBoard(5, 5, 2);
		setBoard(4, 5, 3);
		setBoard(5, 4, 3);
		canMove(2);
	}
	
	public void printMap()
	{
		for(int i = 0 ; i < 10 ; ++i)
		{
			for(int j = 0 ; j < 10 ;++j)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public int reverse(int x, int y, int type) {
		int sum = 0;
		for(int i = x , in = 0; i < 10 ; ++i)
		{
		
			if(board[i][y] == 1 || board[i][y] == 4 || board[i][y] == 0)
			{
				break;
			}
			else if(board[i][y] == type)
			{
				for(int j = x ; j < i ; ++j)
				{
					board[j][y] = type;
					++in;
					++sum;
					
				}
				if(in >= 1)
				{
					--sum;
					break;
				}
	
			}
		}
		for(int i = x , in = 0; i > -1 ; --i)
		{
	
			if(board[i][y] == 1 || board[i][y] == 4 || board[i][y] == 0)
			{
				break;
			}
			else if(board[i][y] == type)
			{
				for(int j = x ; j > i ; --j)
				{
					board[j][y] = type;
					++in;
					++sum;

				}
				if(in >= 1)
				{
					--sum;
					break;
				}
			}
		}
		for(int i = y , in = 0; i < 10 ; ++i)
		{
		
			if(board[x][i] == 1 || board[x][i] == 4 || board[x][i] == 0)
			{
				break;
			}
			else if(board[x][i] == type)
			{
				for(int j = y ; j < i ; ++j)
				{
					
					board[x][j] = type;	
					++in;
					++sum;

				}
				if(in >= 1)
				{
					--sum;
					break;
				};
			}
			
		}
		for(int i = y, in = 0 ; i > -1 ; --i)
		{

			if(board[x][i] == 1 || board[x][i] == 4 || board[x][i] == 0)
			{
				break;
			}
			else if(board[x][i] == type)
			{
				for(int j = y ; j > i ; --j)
				{
					board[x][j] = type;
					++in;
					++sum;

				}
				if(in >= 1)
				{
					--sum;
					break;
				};
			}
		}
		for(int i = 1;;)
		{

			if(x+i > 9 || y+i > 9)
				break;
			
			if(board[x+i][y+i] == 1 || board[x+i][y+i] == 4 || board[x+i][y+i] == 0)
			{
				break;
			}
			else if(board[x+i][y+i] == type)
			{
				int j = 1;
				while( x+j < x+i && y+j < y+i)
				{
					board[x+j][y+j] = type;
					++sum;
					++j;
				}
				break;
			}
			++i;
		}
		for(int i = 1;;)
		{
			if(x-i < 0 || y-i < 0)
				break;
			if(board[x-i][y-i] == 1 || board[x-i][y-i] == 4 || board[x-i][y-i] ==0)
			{
				break;
			}
			else if(board[x-i][y-i] == type)
			{
				int j = 1;
				while( x-j > x-i && y-j > y-i)
				{
					board[x-j][y-j] = type;
					++sum;
					++j;
				}
				break;
			}
			++i;		

		}
		for(int i = 1;;)
		{
			if(x-i < 0 || y+i > 9)
				break;
			if(board[x-i][y+i] == 1 || board[x-i][y+i] == 4 || board[x-i][y+i] == 0)
			{
				break;
			}
			else if(board[x-i][y+i] == type)
			{
				int j = 1;
				while( x-j > x-i && y+j < y+i)
				{
					board[x-j][y+j] = type;
					++sum;
					++j;
				}
				break;
			}
			++i;

		}
		for(int i = 1;;)
		{
			if(x+i > 9 || y-i < 0)
				break;
			if(board[x+i][y-i] == 1 || board[x+i][y-i] == 4 || board[x+i][y-i] == 0)
			{
				break;
			}
			else if(board[x+i][y-i] == type)
			{
				int j = 1;
				while( x+j < x+i && y-j > y-i)
				{
					board[x+j][y-j] = type;
					++sum;
					++j;
				}
				break;
			}
			++i;

		}
//		for(int i = x ; i < 10 ; ++i)
//		{
//			for(int j = y ; j < 10 ; ++j)
//			{
//				if(board[i][j] == type)
//				{
//					for(int m = x ; m < i ; ++m)
//					{
//						for(int n = y ; n < j ; ++n)
//						{
//							board[m+1][n+1] = type;
//						}
//					}
//				}
//
//			}
//		}
//		for(int i = x ; i > -1 ; --i)
//		{
//			for(int j = y ; j > -1 ; --j)
//			{
//				if(board[i][j] == type)
//				{
//					for(int m = x ; m > i ; --m)
//					{
//						for(int n = y ; n > j ; --n)
//						{
//							board[m-1][n-1] = type;
//						}
//					}
//				}
//
//			}
//		}
//		for(int i = x ; i < 10 ; ++i)
//		{
//			for(int j = y ; j > -1 ; --j)
//			{
//				if(board[i][j] == type)
//				{
//					for(int m = x ; m < i ; ++m)
//					{
//						for(int n = y ; n > j ; --n)
//						{
//							board[m+1][n-1] = type;
//						}
//					}
//				}
//
//			}
//		}
//		for(int i = x ; i > -1 ; --i)
//		{
//			for(int j = y ; j < 10 ; ++j)
//			{
//				if(board[i][j] == type)
//				{
//					for(int m = x ; m > i ; --m)
//					{
//						for(int n = y ; n < j ; ++n)
//						{
//							board[m-1][n+1] = type;
//						}
//					}
//				}
//
//			}
//		}
		if(sum >= 8)
			return 1;
		else if(sum >= 5)
			return 2;
		else 
			return 0;
		
	}
	

	private void pathCheck(int x , int y, int type) {
		for(int i = 0 ; i < 10 ; ++i)
		{
			for(int j = 0 ; j < 10 ; ++j)
			{
				if(x != 9)
				{
					if(board[x+1][y] == type)
					{
						for(int k = x+1 ; k < 10 ; ++k)
						{
							if(board[k][y] == 0)
							{
								board[k][y] = 4;
								break;
							}
							else if(board[k][y] == type){
								continue;
							}
							else {
								break;
							}
						}
					}
				}
				if(x != 0)
				{
					if(board[x-1][y] == type)
					{
						for(int k = x-1 ; k > -1 ; --k)
						{
							if(board[k][y] == 0)
							{
								board[k][y] = 4;
								break;
							}
							else if(board[k][y] == type){
								continue;
							}
							else {
								break;
							}
						}
					}
				}
				
				if(y !=  9)
				{
					if(board[x][y+1] == type)
					{
						for(int k = y+1 ; k < 10 ; ++k)
						{
							if(board[x][k] == 0)
							{
								board[x][k] = 4;
								break;
							}
							else if(board[x][k] == type){
								continue;
							}
							else {
								break;
							}
						}
					}
				}
				if(y != 0)
				{
					if(board[x][y-1] == type)
					{
						for(int k = y-1 ; k > -1 ; --k)
						{
							if(board[x][k] == 0)
							{
								board[x][k] = 4;
								break;
							}
							else if(board[x][k] == type){
								continue;
							}
							else {
								break;
							}
						}
					}
				}
				
				if(x != 9 &&  y != 9)
				{
					if(board[x+1][y+1] == type)
					{
						for(int k = 1;;++k)
						{
							if(x+k > 9 || y+k > 9)
								break;
							if(board[x+k][y+k] == 0)
							{
								board[x+k][y+k] = 4;
								break;
							}
							else if(board[x+k][y+k] == type){
								continue;
							}
							else {
								break;
							}
							
						}
					}
				}
				
				if(x != 0 && y != 0)
				{
					if(board[x-1][y-1] == type)
					{
						for(int k = 1;;++k)
						{				
							if(x-k < 0 || y-k < 0)
								break;
							if(board[x-k][y-k] == 0)
							{
								board[x-k][y-k] = 4;
								break;
							}
							else if(board[x-k][y-k] == type){
								continue;
							}
							else {
								break;
							}
			
						}
					}
				}
				
				if( x != 9 && y != 0)
				{
					if(board[x+1][y-1] == type)
					{
						for(int k = 1;;++k)
						{
							if(x+k > 9 || y-k < 0)
								break;
							if(board[x+k][y-k] == 0)
							{
								board[x+k][y-k] = 4;
								break;
							}
							else if(board[x+k][y-k] == type){
								continue;
							}
							else {
								break;
							}
							
						}
					}
				}
				
				if(x != 0 && y != 9)
				{
					if(board[x-1][y+1] == type)
					{
						for(int k = 1;;++k)
						{
							if(x-k < 0 || y+k > 9)
								break;
							if(board[x-k][y+k] == 0)
							{
								board[x-k][y+k] = 4;
								break;
							}
							else if(board[x-k][y+k] == type){
								continue;
							}
							else {
								break;
							}
						}
					}
				}
			}
		}
	}
				
	public void clean() {
		for(int i = 0 ; i < 10 ; ++i)
		{
			for(int j = 0 ; j < 10 ; ++j)
			{
				if(board[i][j] == 4)
					board[i][j] = 0 ;
			}
		}
	}
	public void canMove(int type) {
		if(type == 2)
		{
			for(int i = 0 ; i < 10 ; ++i)
			{
				for(int j = 0 ; j < 10 ; ++j)
				{
					if(board[i][j] == 2)
					{
						pathCheck(i,j,3);
					}
		
				}
			}
		}
		if(type == 3)
		{
			for(int i = 0 ; i < 10 ; ++i)
			{
				for(int j = 0 ; j < 10 ; ++j)
				{
					if(board[i][j] == 3)
					{
						pathCheck(i,j,2);
					}
		
				}
			}
		}
	}
	
	public int getChessNumber(int type)
	{
		int sum = 0;
		for(int i = 0 ; i < 10 ; ++i)
		{
			for(int j = 0 ; j < 10 ; ++j)
			{
				if(board[i][j] == type)
				{
					sum+=1;
				}
			}
		}
		return sum;
	}
	
	public int getType(int x , int y) {
		return board[x][y];
	}
	
	public int isWin() {
		int p1 = getChessNumber(2);
		int p2 = getChessNumber(3);
		if(p1 > p2)
			return 1;
		else if(p1 < p2)
			return 2;
		else
			return 0;
		
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public void setBoard(int x , int y , int type) {
		board[x][y] = type;
	}
	
	public void justForFun() {
		System.out.println("�_��");
	}
	
	//fun
	public static void main(String[] args) {
		Role role = new Role();
		int[][] Bd = new int[10][10];
		role.setBoard(4, 4, 2);
		role.setBoard(5, 5, 2);
		role.setBoard(4, 5, 3);
		role.setBoard(5, 4, 3);
		role.setBoard(5, 3, 2);
		role.reverse(5, 3, 2);
//		role.setBoard(6, 3, 3);
//		role.reverse(6, 3, 3);
//		role.setBoard(3, 6, 2);
//		role.canMove(3);

		Bd = role.getBoard();
		
		
		for(int i = 0 ; i < 10 ; ++i)
		{
			for(int j = 0 ; j < 10 ; ++j)
			{
				System.out.print(Bd[i][j]);
			}
			System.out.println();
			//HI 
		}
		
	}		
}

