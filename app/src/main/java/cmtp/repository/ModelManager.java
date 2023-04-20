package cmtp.repository;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import generated.Conv;
import generated.Msg;

public class ModelManager {
	
	private File convDirectory;
	private Map<BigInteger,File> conversationFiles;
	
	public ModelManager(String dirPath)
	{
		this.convDirectory = new File(dirPath);
		this.conversationFiles = getAllFiles(convDirectory);
	}	
	
	private  Map<BigInteger,File> getAllFiles(File dir) {
	    return Stream.of(dir.listFiles())
	      .filter(file -> !file.isDirectory())
	      .collect(Collectors.toMap(p -> toId(p.getName()), Function.identity()));
	}
	
	private BigInteger toId(String filename)
	{
		int idx = filename.indexOf(".");
		return new BigInteger(filename.substring(0, idx));
	}
	
	public Conv getConv(BigInteger id)
	{		
		Conv conv = null;
		if(conversationFiles.containsKey(id))
		{		
			try {
				JAXBContext jc = JAXBContext.newInstance(Conv.class);
				Unmarshaller unmarshaller = jc.createUnmarshaller();
				conv = (Conv) unmarshaller.unmarshal(conversationFiles.get(id));
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
        return conv;
	}
	
	public ArrayList<Conv> getAllConv()
	{
		return new ArrayList<Conv>();
	}
	
	public Conv createConvAndSave(String convName)
	{
		//TODO
		Conv v = new Conv();
		v.setId(new BigInteger("0"));
		return v;
	}
	
	public void addMsg(Msg msg)
	{
		// TODO use msg.conv_id
	}
	

}
