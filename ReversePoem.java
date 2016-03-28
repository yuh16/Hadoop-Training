import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ReversePoem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File directory = new File(".");
		String path = null;
		try {
			path = directory.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path1 = path + "/test.txt";
		//System.out.println(path1);
		File file = new File(path1);
		OutputStreamWriter Txt = null;
		Txt = new OutputStreamWriter(new FileOutputStream(path1), "GBK");
		Txt.write("窗前明月光\n");
		Txt.write("疑是地上霜\n");
		Txt.write("举头望明月\n");
		Txt.write("低头思故乡\n");
		Txt.close();
		ArrayList<String> list = new ArrayList<String>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(
				new FileInputStream(path1), "GBK"));
		String lineText = null;
		while ((lineText = bf.readLine()) != null) {
			String gbk = lineText;
			list.add(gbk);
			// System.out.println(utf8);
		}
		int n = list.size();

		String path2 = path + "/test2.txt";
		File file2 = new File(path2);
		OutputStreamWriter Txt2 = null;
		Txt2 = new OutputStreamWriter(new FileOutputStream(path2), "UTF-8");
		for (int i = n - 1; i >= 0; i--) {
			if (list.get(i) != null) {
				String gbk = list.get(i);
				String utf8 = new String(gbk.getBytes("UTF-8"));
				//System.out.println(utf8);
				String utf82 = utf8+"\n";
                                System.out.println(utf82);
				Txt2.write(utf82);
			}
		}
		Txt2.close();

	}
}
