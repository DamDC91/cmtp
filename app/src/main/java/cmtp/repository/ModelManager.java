package cmtp.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import generated.Conv;
import generated.Msg;

public class ModelManager 
{
    private File convDirectory;
    private Map<BigInteger,File> conversationFiles;
    private BigInteger maxConvId;
    
    public ModelManager(String dirPath)
    {
        this.convDirectory = new File(dirPath);
        this.conversationFiles = getAllFiles(convDirectory);
        this.maxConvId = Collections.max(conversationFiles.keySet());
    }	
    
    private Map<BigInteger,File> getAllFiles(File dir) 
    {
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
            try 
            {
                JAXBContext jc = JAXBContext.newInstance(Conv.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                conv = (Conv) unmarshaller.unmarshal(conversationFiles.get(id));
            }
            catch (JAXBException e) 
            {
                e.printStackTrace();
            }
        }
        return conv;
    }
    
    public ArrayList<Conv> getAllConv()
    {
        return conversationFiles.keySet().stream()
            .map(id -> getConv(id))
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public Conv createConvAndSave(String convName)
    {
        Conv conv = new Conv();
        conv.setId(getNextConvId());

        saveConversation(conv);

        return conv;
    }

    public class UnknownConversation extends Exception {}
    
    public void addMsg(Msg msg) throws UnknownConversation
    {
        Conv conv = getConv(msg.getConvId());
        if (conv == null) 
        {
            throw new UnknownConversation();
        }
        else
        {
            conv.getMsg().add(msg);
            saveConversation(conv);
        }
    }
    

    private void saveConversation(Conv conv)
    {
        File convFile = conversationFiles.get(conv.getId());
        if (convFile == null)
        {
            convFile = new File(convDirectory, conv.getId().toString() + ".xml");
            conversationFiles.put(conv.getId(), convFile);
        }

        try (FileWriter fWriter = new FileWriter(convFile)) 
        {
            JAXBContext.newInstance(Conv.class).createMarshaller().marshal(conv, fWriter);
        }
        catch (IOException e)   { e.printStackTrace(); }
        catch (JAXBException e) { e.printStackTrace(); }
    }

    private BigInteger getNextConvId()
    {
        maxConvId = maxConvId.add(BigInteger.ONE);
        return maxConvId;
    }

}
