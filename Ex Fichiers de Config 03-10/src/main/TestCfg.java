package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Properties;
import java.io.FileNotFoundException;

public class TestCfg {

	private String charset;
	private String windowColor;
	private String defaultFont;
	private final File file = new File ("config/config.ini");
	private int lapin;
	
	
	public TestCfg () {
	}

	public void loadCfg () throws FileNotFoundException, IOException {
		
		Properties p = new Properties ();
		p.load (new FileInputStream(file));
		charset = p.getProperty("charset");
		windowColor = p.getProperty("windowColor");
		defaultFont = p.getProperty("defaultFont");
		lapin = Integer.parseInt(p.getProperty("timer")); //pour transformer String to Int 
	
		// la variable n'a pas forcement le meme nom que la clé, ici : int lapin extrait la clé "timer"
	}
		
	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getWindowColor() {
		return windowColor;
	}

	public void setWindowColor(String windowColor) {
		this.windowColor = windowColor;
	}

	public String getDefaultFont() {
		return defaultFont;
	}

	public void setDefaultFont(String defaultFont) {
		this.defaultFont = defaultFont;
	}

	public File getFile() {
		return file;
	}
	
	
	public int getTimer() {
		return lapin;
	}

	public void setTimer(int timer) {
		this.lapin = timer;
	}

	@Override
	public String toString() {
		return "TestCfg [charset=" + charset + ", windowColor=" + windowColor + ", defaultFont=" + defaultFont
				+ ", file= " + file + ", timer=" + lapin +"]";
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		TestCfg cfg = new TestCfg ();
		cfg.loadCfg();
		System.out.println(cfg.toString());


	}

}
