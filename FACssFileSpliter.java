import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FACssFileSpliter {

	public static void main(String[] args) {
		new FACssFileSpliter("font-awesome.css", "strings.xml");
	}

	public class FAObject {
		private String iconName;
		private String iconContent;
		public FAObject(String iconName) {
			this.iconName = iconName.replaceAll("-", "_");
		}
		public FAObject setIconContent(String iconContent) {
			this.iconContent = iconContent.replace("\\f", "&#xf");
			return this;
		}
		@Override
		public String toString() {
			return "<string name=\""+iconName+"\">"+iconContent+";</string>";
		}
	}

	
	
	public FACssFileSpliter(String fromFileName, String toFileName) {
		// saving each css object
		List<FAObject> list = new LinkedList<FAObject>();
		// handling the obj name using same content in css file
		Stack<FAObject> stack = new Stack<FAObject>();

		// read
		try (
			FileInputStream in = new FileInputStream(new File(fromFileName));
			BufferedReader reader = new BufferedReader(new InputStreamReader(in))
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.equals("}")) {
					stack.clear();
				}
				if (line.contains("content")) {
					String content = line.split("\"")[1];
					while (!stack.isEmpty()) {
						list.add(stack.pop().setIconContent(content));
					}
				}
				if (line.startsWith(".")) {
					String name = line.split("\\.")[1].split(":")[0];
					stack.push(new FAObject(name));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		writeToFile(toFileName, list);
	}

	
	
	public void writeToFile(String filename, List<FAObject> list) {
		try (
			FileOutputStream out = new FileOutputStream(new File(filename));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))
		) {
			writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			writer.newLine();
			writer.write("<resources>");
			writer.newLine();
			for (FAObject eachObj : list) {
				writer.write("\t"+eachObj.toString());
				writer.newLine();
			}
			writer.write("</resources>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
