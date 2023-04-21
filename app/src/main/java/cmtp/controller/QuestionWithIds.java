package cmtp.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import generated.Question;

public class QuestionWithIds {
	
	private Question question;
	private ArrayList<BigInteger> ids;
	
	public QuestionWithIds(Question q, ArrayList<BigInteger> ids)
	{
		this.question = q;
		this.ids = ids;
	}
	
	public Question getQuestion()
	{
		return question;
	}
	
	public String getFullId()
	{
		return String.join("/", Stream.concat(ids.stream(), Stream.of(question.getId()))
				.map(e -> e.toString())
				.collect(Collectors.toList()));
	}
	
	public ArrayList<BigInteger> getParentIdList()
	{
		return ids;
	}

}
