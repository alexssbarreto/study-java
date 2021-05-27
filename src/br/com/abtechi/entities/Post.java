package br.com.abtechi.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	List<Comments> comments = new ArrayList<Comments>();
	
	public Post () {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		super();
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	public void addComments(Comments comment) {
		this.comments.add(comment);
	}
	
	public void removeComment(Comments comment) {
		this.comments.remove(comment);
	}

	public List<Comments> getComments() {
		return comments;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getTitle() + System.lineSeparator());
		sb.append(this.getLikes() + " - " + sdf.format(this.getMoment()) + System.lineSeparator());
		sb.append(this.getContent() + System.lineSeparator());
		sb.append("Comentários:" + System.lineSeparator());
		
		for (Comments comment : this.comments) {
			sb.append(comment.getText() + System.lineSeparator());
		}
		
		return sb.toString();
	}
}
