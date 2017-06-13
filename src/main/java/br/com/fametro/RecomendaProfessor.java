package br.com.fametro;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendaProfessor {
	public static void main(String[] args) throws IOException, TasteException {
		File file = new File("src/ProfNotasFametro.csv");
		DataModel model = new FileDataModel(file);
		
		//chama o criador de recomendações
		Recommender recommender = new RecomendadorBuilder().buildRecommender(model);
		
		//recomendações
		List<RecommendedItem> recommendations = recommender.recommend(9, 3);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
			
		}
	}
}
