package br.com.fametro;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendadorBuilder implements RecommenderBuilder {

	public Recommender buildRecommender(DataModel model) throws TasteException {
		//função de similaridade
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		//calcula proximidade dos vizinhos mais próximos
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		//cria recomendador
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		return recommender;		
	}

}
