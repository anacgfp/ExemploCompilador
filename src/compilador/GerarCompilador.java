package compilador;
import javax.script.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

public class GerarCompilador {

	public void main() throws Exception {
		System.out.println("Gerando compilador:");
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("peg-0.10.0.js"));
		engine.put("desc",new String(Files.readAllBytes(Paths.get("desc.peg"))));
		Object code = engine.eval("peg.generate(desc,{output:'source'})");
		Files.write(Paths.get("parser.js"), code.toString().getBytes());
		System.out.println("Compilador gerado! :)");
	}

}
