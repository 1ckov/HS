package pr1.uebung07;

import static org.junit.Assert.assertArrayEquals;
import static pr.MakeItSimple.print;
import static pr.MakeItSimple.println;

import org.junit.Test;

public class Labyrinth1stTest {

	private void assertEquals(char[][]expected, char[][] actual) {
		for (int row = 0; row < expected.length; row++)
			assertArrayEquals("Zeile " + row, expected[row], actual[row]);
	}
	
	@Test
	public void mazeExample() {
		char[][] lab = new char[][] {
			"## #######".toCharArray(),
			"#        #".toCharArray(),
			"# ###### #".toCharArray(),
			"#     ## #".toCharArray(),
			"##### ## S".toCharArray(),
			"#   # ####".toCharArray(),
			"# # #    #".toCharArray(),
			"# # #### #".toCharArray(),
			"# #      #".toCharArray(),
			"# ########".toCharArray(),
		};
		
		Maze.findWay(lab);
		
		for (int row = 0; row < lab.length; row++) {
			for (int col = 0; col < lab[0].length; col++)
				print("" + lab[row][col]);
			println();
		}
		
		assertEquals(new char[][] {
			"##E#######".toCharArray(),
			"# .......#".toCharArray(),
			"# ######.#".toCharArray(),
			"#     ##.#".toCharArray(),
			"##### ##..".toCharArray(),
			"#   # ####".toCharArray(),
			"# # #    #".toCharArray(),
			"# # #### #".toCharArray(),
			"# #      #".toCharArray(),
			"# ########".toCharArray(),
		}, lab);
	}

}