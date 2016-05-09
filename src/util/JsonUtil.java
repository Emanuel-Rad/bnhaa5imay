package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import model.Package;
import model.Part;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

public class JsonUtil {
	
	public static void writePackages(OutputStream out, Collection<Package> packages) throws IOException {
		try (JsonWriter writer = new JsonWriter(new OutputStreamWriter(out))) {
			writer.setIndent("  ");
			writer.beginArray();
			for(Package p: packages)
				writePackage(writer, p);
			writer.endArray();
		}
	}
	
	private static void writePackage(JsonWriter writer, Package p) throws IOException {
		writer.setIndent("  ");
		writer.beginObject();
		writer.name("id").value(p.getId());
		writer.name("weight").value(p.getWeight());
		writer.setIndent("  ");
		writer.beginArray();
		for(Part part: p.getParts()) {
			writer.setIndent("  ");
			writer.beginObject();
			writer.name("label").value(part.getLabel());
			writer.name("type").value(part.getType());
			writer.name("weight").value(part.getWeight());
			writer.name("isContaminated").value(part.isContaminated());
			writer.endObject();
		}
		writer.endArray();
		writer.endObject();
	}
	
	public static ArrayList<Package> readPackages(InputStream in) throws IOException {
		JsonParser parser = new JsonParser();
		try (InputStreamReader reader = new InputStreamReader(in)) {
			JsonArray array = parser.parse(reader).getAsJsonArray();
			ArrayList<Package> packages = new ArrayList<>(array.size());
			for(JsonElement element: array)
				packages.add(readPackage(reader, element.getAsJsonObject()));
			return packages;
		}
	}
	
	public static Package readPackage(InputStreamReader reader, JsonObject object) {
		JsonElement id = object.get("id");
		JsonElement weight = object.get("weight");
		Package p = new Package(id.getAsInt());
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(reader).getAsJsonArray();
		for(JsonElement element: array) {
			JsonObject obj = element.getAsJsonObject();
			String label = obj.get("label").getAsString();
			String type = obj.get("type").getAsString();
			int weightt = obj.get("weight").getAsInt();
			boolean isContaminated = obj.get("isContaminated").getAsBoolean();		
			Part part = new Part(label, type, weightt, isContaminated);		
			p.addPart(part);
		}
		return p;
	}
}
