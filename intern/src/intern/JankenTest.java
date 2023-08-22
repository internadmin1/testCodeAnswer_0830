package intern;

import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Test;


class JankenTest {
	@Test
	void test_main() {
		String stdIn = "a\n-1\n3\n1";
		InputStream in = new ByteArrayInputStream(stdIn.getBytes());
		System.setIn(in);
		Janken.main(new String[]{});
	}
	
	@Test
	void test_getUser() {
		String stdIn = "a\n-1\n3\n1";
		InputStream in = new ByteArrayInputStream(stdIn.getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		int result = Janken.getUser();
	}
	
	@Test
	void test_getPC() {
		int result = Janken.getPc();
		assertThat(result, anyOf(equalTo(0), equalTo(1), equalTo(2)));
	}
	
	@Test
	void test_judgeJanken() {
		assertEquals("勝ち",Janken.judgeJanken(0,1));
		assertEquals("勝ち",Janken.judgeJanken(1,2));
		assertEquals("勝ち",Janken.judgeJanken(2,0));
		assertEquals("まけ",Janken.judgeJanken(0,2));
		assertEquals("まけ",Janken.judgeJanken(1,0));
		assertEquals("まけ",Janken.judgeJanken(2,1));
		assertEquals("あいこ",Janken.judgeJanken(0,0));
		assertEquals("あいこ",Janken.judgeJanken(1,1));
		assertEquals("あいこ",Janken.judgeJanken(2,2));
	}
	
	@Test
	void test_showResult() {
		Janken.showResult(0,0,"あいこ");
	}
}
