package br.com.abtechi.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.abtechi.entities.Comments;
import br.com.abtechi.entities.Post;

public class ProgramaPost {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		
		// estruturação de dados para trabalho com Composição
		Post post1 = new Post();
		post1.setTitle("Título do post 1");
		post1.setContent("Conteúdo do post 1");
		post1.setMoment(sdf.parse("27/05/2021 15:26:31"));
		post1.setLikes(20);
		
		Comments comment1 = new Comments("Comentário 1 do Post 1");
		Comments comment2 = new Comments("Comentário 2 do Post 1");
		
		post1.addComments(comment1);
		post1.addComments(comment2);
		
		Post post2 = new Post();
		post2.setTitle("Título do post 2");
		post2.setContent("Conteúdo do post 2");
		post2.setMoment(sdf.parse("28/05/2021 14:00:32"));
		post2.setLikes(20);
		
		Comments comment3 = new Comments("Comentário 1 do Post 2");
		Comments comment4 = new Comments("Comentário 2 do Post 2");
		
		post2.addComments(comment3);
		post2.addComments(comment4);

		
		// impressão dos dados
		System.out.println(post1);
		System.out.println(post2);
	}

}
