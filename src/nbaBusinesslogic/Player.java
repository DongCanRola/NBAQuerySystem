package nbaBusinesslogic;
import nbaBusinessLogicService.PlayerService;
import nbaquery.data.Column;
import nbaquery.data.Row;
import nbaquery.data.Table;
import nbaquery.data.TableHost;
import nbaquery.data.query.DeriveQuery;
import nbaquery.data.query.Query;


public class Player implements PlayerService{

	TableHost host;
	Table players=host.getTable("playerMessage");
	
	public void threeShootAccuracy(){
		Query query = new DeriveQuery(players, new String[]{"three_shoot_accuracy"}, new Class<?>[]{Float.class})
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
		host.performQuery(query, "playerMessage");
	}
	
	public void shootAccuracy(){
		Query query = new DeriveQuery(players, new String[]{"shoot_accuracy"}, new Class<?>[]{Float.class})
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
		host.performQuery(query, "playerMessage");
	}
	
	public void penaltyShootAccuracy(){
		Query query = new DeriveQuery(players, new String[]{"penalty_shoot_accuracy"}, new Class<?>[]{Float.class})
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
		host.performQuery(query, "playerMessage");
	}
	
	public void efficiency(){
		Query query = new DeriveQuery(players, new String[]{"efficiency"}, new Class<?>[]{Integer.class})
		{
			Column score;
			Column backboard;
			Column assist;
			Column steal;
			Column block_shot;
			Column penalty_shoot_count;
			Column penalty_shoot_score;
			Column error;
			Column efficiency;
			
			@Override
			public void retrieve(Table table)
			{
				score = table.getColumn("score");
				backboard = table.getColumn("backboard");
				assist = table.getColumn("assist");
				steal = table.getColumn("steal");
				block_shot = table.getColumn("block_shot");
				penalty_shoot_count = table.getColumn("penalty_shoot_count");
				penalty_shoot_score = table.getColumn("penalty_shoot_score");
				error = table.getColumn("error");
				efficiency = table.getColumn("efficiency");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer score_value = (Integer)score.getAttribute(row);
				Integer backboard_value = (Integer)backboard.getAttribute(row);
				Integer assist_value=(Integer)assist.getAttribute(row);
				Integer steal_value=(Integer)steal.getAttribute(row);
				Integer block_shot_value=(Integer)block_shot.getAttribute(row);
				Integer penalty_shoot_count_value=(Integer)penalty_shoot_count.getAttribute(row);
				Integer penalty_shoot_score_value=(Integer)penalty_shoot_score.getAttribute(row);
				Integer error_value=(Integer)error.getAttribute(row);
				
				efficiency.setAttribute(row,  (score_value + backboard_value + assist_value + steal_value + 
						block_shot_value) -(penalty_shoot_count_value - penalty_shoot_score_value) - error_value);
			}
		};
		host.performQuery(query, "playerMessage");
	}
	
	public void GmSc(){
		Query query = new DeriveQuery(players, new String[]{"GmSc"}, new Class<?>[]{Float.class})
		{
			Column score;
			Column shoot_score;
			Column shoot_count;
			Column penalty_count;
			Column penalty_score;
			Column offensive_rebound;//前场篮板数
			Column defensive_rebound;//后场篮板数
			Column steal;
			Column assist;
			Column block_shot;
			Column foul;
			Column error;
			Column GmSc_efficiency;
			
			@Override
			public void retrieve(Table table)
			{
				score = table.getColumn("score");
				shoot_count = table.getColumn("shoot_count");
				shoot_score = table.getColumn("shoot_score");
				penalty_count = table.getColumn("penalty_count");
				penalty_score = table.getColumn("penalty_score");
				offensive_rebound = table.getColumn("offensive_rebound_rate");
				defensive_rebound = table.getColumn("defensive_rebound_rate");
				steal = table.getColumn("steal");
				assist = table.getColumn("assist");
				block_shot = table.getColumn("block_shot");
				foul = table.getColumn("foul");
				error = table.getColumn("error");
				GmSc_efficiency = table.getColumn("GmSc_efficiency");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer score_value = (Integer)score.getAttribute(row);
				Integer shoot_count_value = (Integer)shoot_count.getAttribute(row);
				Integer shoot_score_value = (Integer)shoot_score.getAttribute(row);
				Integer penalty_count_value = (Integer)penalty_count.getAttribute(row);
				Integer penalty_score_value = (Integer)penalty_score.getAttribute(row);
				Integer offensive_rebound_value = (Integer)offensive_rebound.getAttribute(row);
				Integer defensive_rebound_value = (Integer)defensive_rebound.getAttribute(row);
				Integer steal_value = (Integer)steal.getAttribute(row);
				Integer assist_value = (Integer)assist.getAttribute(row);
				Integer block_shot_value = (Integer)block_shot.getAttribute(row);
				Integer foul_value = (Integer)foul.getAttribute(row);
				Integer error_value = (Integer)error.getAttribute(row);
				
				GmSc_efficiency.setAttribute(row, score_value + 0.4*shoot_score_value - 0.7*shoot_count_value -
						0.4*(penalty_count_value - penalty_score_value) + 0.7*offensive_rebound_value + 
						0.3*defensive_rebound_value + steal_value + 0.7*assist_value + 0.7*block_shot_value -
						0.4*foul_value - error_value);
			}
		};
		host.performQuery(query, "playerMessage");
	}
	
	public void factShootAccuracy(){
		Query query = new DeriveQuery(players, new String[]{"fact_shoot_accuracy"}, new Class<?>[]{Float.class})
		{
			Column score;
			Column shoot_count;
			Column penalty_shoot_count;
			Column fact_shoot_accuracy;
			
			@Override
			public void retrieve(Table table)
			{
				score = table.getColumn("score");
				penalty_shoot_count = table.getColumn("penalty_shoot_count");
				shoot_count = table.getColumn("shoot_count");
				fact_shoot_accuracy = table.getColumn("fact_shoot_accuracy");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer shoot_count_value = (Integer)shoot_count.getAttribute(row);
				Integer penalty_shoot_count_value = (Integer)penalty_shoot_count.getAttribute(row);
				if((penalty_shoot_count_value + shoot_count_value) == 0) return;
				Integer score_value = (Integer)score.getAttribute(row);
				
				fact_shoot_accuracy.setAttribute(row, score_value/(2*(shoot_count_value + 0.44*penalty_shoot_count_value)));
			}
		};
		host.performQuery(query, "playerMessage");
	}
	
	public void shootEfficiency(){
		Query query = new DeriveQuery(players, new String[]{"shoot_efficiency"}, new Class<?>[]{Float.class})
		{
			Column shoot_count;
			Column shoot_score;
			Column three_shoot_score;
			Column shoot_efficiency;
			
			@Override
			public void retrieve(Table table)
			{
				shoot_count = table.getColumn("shoot_count");
				shoot_score = table.getColumn("shoot_score");
				three_shoot_score = table.getColumn("three_shoot_score");
				shoot_efficiency = table.getColumn("shoot_efficiency");
			}
			
			@Override
			public void derive(Row row)
			{
				Integer shoot_count_value = (Integer)shoot_count.getAttribute(row);
				if(shoot_count_value == 0) return;
				Integer shoot_score_value = (Integer)shoot_score.getAttribute(row);
				Integer three_shoot_score_value = (Integer)three_shoot_score.getAttribute(row);
				
				shoot_efficiency.setAttribute(row, 1.0f * (shoot_score_value + 0.5*three_shoot_score_value) / shoot_count_value);
			}
		};
		host.performQuery(query, "playerMessage");
	}
	
	public void backboardAccuracy(){

	}
	
	public void offensiveReboundRate(){
		
	}
	
	public void defensiveReboundRate(){
		
	}
	
	public void assistRate(){
		
	}
	
	public void stealsRate(){
		
	}
	
	public void capRate(){
		
	}
	
	public void errorRate(){
		
	}
	
	public void useRate(){
		
	}
	
	@Override
	public Table searchForPlayers(boolean type, String head,
			boolean upOrDown, String position, String league) {
		// TODO Auto-generated method stub
		Table result=host.getTable("resultPlayers");
		return result;
	}

}
