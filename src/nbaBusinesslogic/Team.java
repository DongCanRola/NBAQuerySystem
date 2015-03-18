package nbaBusinesslogic;
import nbaBusinessLogicService.TeamService;
import nbaquery.data.Table;
import nbaquery.data.TableHost;
import nbaquery.data.Column;
import nbaquery.data.Row;
import nbaquery.data.query.DeriveQuery;
import nbaquery.data.query.Query;

public class Team implements TeamService{
	
	TableHost host;
	Table team=host.getTable("teamMessage");

	public void shootAccuracy(){
		Query query = new DeriveQuery(team, new String[]{"shoot_accuracy"}, new Class<?>[]{Float.class})
		{
			Column shoot_count;
			Column shoot_score;
			Column shoot_accuracy;
			
			@Override
			public void retrieve(Table table)
			{
				shoot_count = table.getColumn("shoot_count");
				shoot_score = table.getColumn("shoot_score");
				shoot_accuracy = table.getColumn("shoot_accuracy");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer shoot_count_value = (Integer)shoot_count.getAttribute(row);
				if(shoot_count_value == 0) return;
				Integer shoot_score_value = (Integer)shoot_score.getAttribute(row);
				
				shoot_accuracy.setAttribute(row, 1.0f * shoot_score_value / shoot_count_value);
			}
		};
		host.performQuery(query, "teamMessage");
	}
	
	public void threeShootAccuracy(){
		Query query = new DeriveQuery(team, new String[]{"three_shoot_accuracy"}, new Class<?>[]{Float.class})
		{
			Column three_shoot_count;
			Column three_shoot_score;
			Column three_shoot_accuracy;
			
			@Override
			public void retrieve(Table table)
			{
				three_shoot_count = table.getColumn("three_shoot_count");
				three_shoot_score = table.getColumn("three_shoot_score");
				three_shoot_accuracy = table.getColumn("three_shoot_accuracy");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer three_shoot_count_value = (Integer)three_shoot_count.getAttribute(row);
				if(three_shoot_count_value == 0) return;
				Integer three_shoot_score_value = (Integer)three_shoot_score.getAttribute(row);
				
				three_shoot_accuracy.setAttribute(row, 1.0f * three_shoot_score_value / three_shoot_count_value);
			}
		};
		host.performQuery(query, "teamMessage");
	}
	
	public void penaltyShootAccuracy(){
		Query query = new DeriveQuery(team, new String[]{"penalty_shoot_accuracy"}, new Class<?>[]{Float.class})
		{
			Column penalty_shoot_count;
			Column penalty_shoot_score;
			Column penalty_shoot_accuracy;
			
			@Override
			public void retrieve(Table table)
			{
				penalty_shoot_count = table.getColumn("penalty_shoot_count");
				penalty_shoot_score = table.getColumn("penalty_shoot_score");
				penalty_shoot_accuracy = table.getColumn("penalty_shoot_accuracy");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer penalty_shoot_count_value = (Integer)penalty_shoot_count.getAttribute(row);
				if(penalty_shoot_count_value == 0) return;
				Integer penalty_shoot_score_value = (Integer)penalty_shoot_score.getAttribute(row);
				
				penalty_shoot_accuracy.setAttribute(row, 1.0f * penalty_shoot_score_value / penalty_shoot_count_value);
			}
		};
		host.performQuery(query, "teamMessage");
	}
	
	public void successRate(){
		
	}
	
	public void offensiveEfficiency(){
		Query query = new DeriveQuery(team, new String[]{"offensive_efficiency"}, new Class<?>[]{Float.class})
		{
			Column offensive_count;
			Column score;
			Column offensive_efficiency;
			
			@Override
			public void retrieve(Table table)
			{
				offensive_count = table.getColumn("offensive_count");
				score = table.getColumn("score");
				offensive_efficiency = table.getColumn("offensive_efficiency");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer offensive_count_value = (Integer)offensive_count.getAttribute(row);
				if(offensive_count_value == 0) return;
				Integer score_value = (Integer)score.getAttribute(row);
				
				offensive_efficiency.setAttribute(row, 1.0f * 100 * score_value / offensive_count_value);
			}
		};
		host.performQuery(query, "teamMessage");
	}
	
	public void defensiveEfficiency(){
		
	}
	
	public void backboardEfficiency(){
		
	}
	
	public void stealsRate(){
		Query query = new DeriveQuery(team, new String[]{"steal_rate"}, new Class<?>[]{Float.class})
		{
			Column defensive_count;
			Column steal_count;
			Column steal_rate;
			
			@Override
			public void retrieve(Table table)
			{
				defensive_count = table.getColumn("defensive_count");
				steal_count = table.getColumn("steal_count");
				steal_rate = table.getColumn("steal_rate");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer defensive_count_value = (Integer)defensive_count.getAttribute(row);
				if(defensive_count_value == 0) return;
				Integer steal_count_value = (Integer)steal_count.getAttribute(row);
				
				steal_rate.setAttribute(row, 1.0f * 100 * steal_count_value / defensive_count_value);
			}
		};
		host.performQuery(query, "teamMessage");
	}
	
	public void assistRate(){
		Query query = new DeriveQuery(team, new String[]{"assist_rate"}, new Class<?>[]{Float.class})
		{
			Column offensive_count;
			Column assist_count;
			Column assist_rate;
			
			@Override
			public void retrieve(Table table)
			{
				offensive_count = table.getColumn("offensive_count");
			    assist_count = table.getColumn("assist_count");
				assist_rate = table.getColumn("assist_rate");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer offensive_count_value = (Integer)offensive_count.getAttribute(row);
				if(offensive_count_value == 0) return;
				Integer assist_count_value = (Integer)assist_count.getAttribute(row);
				
				assist_rate.setAttribute(row, 1.0f * 100 * assist_count_value / offensive_count_value);
			}
		};
		host.performQuery(query, "teamMessage");
	}
	
	@Override
	public Table searchForTeams(boolean type, String head,
			boolean upOrDown, String position, String league) {
		// TODO Auto-generated method stub
		Table result=host.getTable("teamMessage");
		return result;
	}

}
