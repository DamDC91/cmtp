package cmtp.repository;

import java.util.Optional;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import generated.Conv;
import generated.Form;
import generated.Msg;
import generated.Question;
import generated.Reply;

public class ReferenceResolver
{
	static public Optional<Question> getQuestion(Conv c, Reply r)
	{
		// TODO: returning the corresponding form/question
        String id = r.getQuestionId();
        for (Msg msg : c.getMsg())
        {
            for (Object o : msg.getData().getQuestionOrReplyOrForm())
            {
                if (matchQuestion(o, id))
                    return Optional.of((Question) o);
                else if (matchForm(o, id))
                    return formResolver((Form) o, id);
            }
        }

        return Optional.empty();
	}

    static private boolean matchQuestion(Object o, String id)
    {
        return o instanceof Question && ((Question) o).getId().equals(id);
    }

    static private boolean matchForm(Object o, String id)
    {
        return o instanceof Form && ((Form) o).getId().equals(id.split("/")[0]);
    }

    static private Optional<Question> formResolver(Form f, String id)
    {
        for (Object o : f.getQuestionOrTextOrForm())
        {
            if (matchQuestion(o, id.substring(id.indexOf('/') + 1)))
                return Optional.of((Question) o);
            else if (matchForm(o, id.split("/")[1]))
                return formResolver(f, id.substring(id.indexOf('/') + 1));
        }

        return Optional.empty();
    }

    public static void main(String args[])
    {
        try
        {
            JAXBContext jc = JAXBContext.newInstance(Conv.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Conv conv = (Conv) unmarshaller.unmarshal(new File("./conv-example.xml"));
            for (Msg msg : conv.getMsg())
            {
                for (Object o : msg.getData().getQuestionOrReplyOrForm())
                {
                    if (o instanceof Reply)
                    {
                        Optional<Question> q = ReferenceResolver.getQuestion(conv, (Reply) o);
                        if (q.isPresent())
                            System.out.println("Reply id: " + q.get().getId() + " --> " + ((Reply) o).getQuestionId());
                        else
                            System.out.println("Unable to find the question for answer " + ((Reply) o).getQuestionId());
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
