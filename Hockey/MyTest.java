package m;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.*;

public class MyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	PlayersFinder d=new PlayersFinder();
	//Test cases for addition
	@Test
	public void test1() {
		String[] photo = {
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"
				};
		Point[] result = new Point[50];
		result[0] = new Point() ;
		result[0].setLocation(4,5);
		result[1] = new Point() ;
		result[1].setLocation(13,19);
		result[2] = new Point() ;
		result[2].setLocation(14,2);
		Point[] y=d.findPlayers(photo,3,16);
		int count=0;
		for(int i=0;i<50;i++) {
			 if(result[i]==null && y[i]==null) {
				break;
			}
			if(result[i].x==y[i].x&&result[i].y==y[i].y) {
				count++;
			}

		}
		assertEquals(count,2);
	}
	
	@Test
	public void test2() {
		String[] photo = {
				"11111",
				"1AAA1",
				"1A1A1",
				"1AAA1",
				"11111"
				};
		Point[] result = new Point[50];
		result[0] = new Point() ;
		result[0].setLocation(5,5);
		result[1] = new Point() ;
		result[1].setLocation(5,5);
		Point[] y=d.findPlayers(photo,1,3);
		int count=0;
		for(int i=0;i<50;i++) {
			 if(result[i]==null && y[i]==null) {
				break;
			}
			if(result[i].x==y[i].x&&result[i].y==y[i].y) {
				count++;
			}

		}
		assertEquals(count,2);
	}
	@Test
	public void test3() {
		String[] photo = {
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"
				};
		Point[] result = new Point[50];
		result[0] = new Point() ;
		result[0].setLocation(3,8);
		result[1] = new Point() ;
		result[1].setLocation(4,16);
		result[2] = new Point() ;
		result[2].setLocation(5,4);
		result[3] = new Point() ;
		result[3].setLocation(16,3);
		result[4] = new Point() ;
		result[4].setLocation(16,17);
		result[5] = new Point() ;
		result[5].setLocation(17,9);
		Point[] y=d.findPlayers(photo,4,16);
		int count=0;
		for(int i=0;i<50;i++) {
			 if(result[i]==null && y[i]==null) {
				break;
			}
			if(result[i].x==y[i].x&&result[i].y==y[i].y) {
				count++;
			}

		}
		assertEquals(count,6);
	}
	@Test
	public void test4() {
		String[] photo = {
					"8D88888J8L8E888",
					"88NKMG8N8E8JI88",
					"888NS8EU88HN8EO",
					"LUQ888A8TH8OIH8",
					"888QJ88R8SG88TY",
					"88ZQV88B88OUZ8O",
					"FQ88WF8Q8GG88B8",
					"8S888HGSB8FT8S8",
					"8MX88D88888T8K8",
					"8S8A88MGVDG8XK8",
					"M88S8B8I8M88J8N",
					"8W88X88ZT8KA8I8",
					"88SQGB8I8J88W88",
					"U88H8NI8CZB88B8",
					"8PK8H8T8888TQR8"
				};
		Point[] result = new Point[50];
		result[0] = new Point() ;
		result[0].setLocation(1,17);
		result[1] = new Point() ;
		result[1].setLocation(3,3);
		result[2] = new Point() ;
		result[2].setLocation(3,10);
		result[3] = new Point() ;
		result[3].setLocation(3,25);
		result[4] = new Point() ;
		result[4].setLocation(5,21);
		result[5] = new Point() ;
		result[5].setLocation(8,17);
		result[6] = new Point() ;
		result[6].setLocation(9,2);
		result[7] = new Point() ;
		result[7].setLocation(10,9);
		result[8] = new Point() ;
		result[8].setLocation(12,23);
		result[9] = new Point() ;
		result[9].setLocation(17,16);
		result[10] = new Point() ;
		result[10].setLocation(18,3);
		result[11] = new Point() ;
		result[11].setLocation(18,11);
		result[12] = new Point() ;
		result[12].setLocation(18,28);
		result[13] = new Point() ;
		result[13].setLocation(22,20);
		result[14] = new Point() ;
		result[14].setLocation(23,26);
		result[15] = new Point() ;
		result[15].setLocation(24,15);
		result[16] = new Point() ;
		result[16].setLocation(27,2);
		result[17] = new Point() ;
		result[17].setLocation(28,26);
		result[18] = new Point() ;
		result[18].setLocation(29,16);
		Point[] y=d.findPlayers(photo,8,9);
		int count=0;
		for(int i=0;i<50;i++) {
			 if(result[i]==null && y[i]==null) {
				break;
			}
			if(result[i].x==y[i].x&&result[i].y==y[i].y) {
				count++;
			}

		}
		assertEquals(count,19);
	}
	//team doesn't exist
	@Test
	public void test5() {
		String[] photo = {
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"
				};
		int len=50;
		Point[] result = new Point[50];
		Point[] y = d.findPlayers(photo,9,16);
		int count=0;

		for(int i=0;i<len;i++) {
			 if(result[i]==null && y[i]==null) {
				break;
			}
			if(result[i].x==y[i].x&&result[i].y==y[i].y) {
				count++;
			}

		}
		
		assertEquals(count,0);
	}
	//team area is smaller than threshold
	@Test
	public void test6() {
		String[] photo = {
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"
				};
		int len=50;
		Point[] result = new Point[50];
		Point[] y = d.findPlayers(photo,4,17);
		int count=0;

		for(int i=0;i<len;i++) {
			 if(result[i]==null && y[i]==null) {
				break;
			}
			if(result[i].x==y[i].x&&result[i].y==y[i].y) {
				count++;
			}

		}
		
		assertEquals(count,0);
	}

}
