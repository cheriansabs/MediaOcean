package com.xyz.scheduler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.xyz.model.Match;

public class Scheduler {

	public String getSchedule(List<String> listTeam, Date date) {
		// TODO Auto-generated meth od stub

		List<Match> lstMatches = ListMatches(listTeam);
		List<String> lstTeamsPlayed = new ArrayList<>();
		// List<Match> mementoMatches = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int matchCount = 0;
		StringBuffer sb = new StringBuffer();
		while (lstMatches.size() > 0) {

			if (matchCount == 2) {
				cal.add(Calendar.DATE, 1);
				matchCount = 0;
			}

			Match match = lstMatches.get(0);

			if (lstTeamsPlayed.contains(match.getTeam1()) || lstTeamsPlayed.contains(match.getTeam2())) {
				match = null;
				for (Match match1 : lstMatches) {

					if (!lstTeamsPlayed.contains(match1.getTeam1()) && !lstTeamsPlayed.contains(match1.getTeam2())) {
						match = match1;
						break;
					}

				}

			}
			if (match != null) {

				/*System.out.println(cal.get(Calendar.DATE) + "//" + cal.get(Calendar.MONTH)+1 + "//"
						+ cal.get(Calendar.YEAR) + "  " + match.getTeam1() + " vs " + match.getTeam2());*/
				sb.append(cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH)+1 + "/" + cal.get(Calendar.YEAR) + "  "
						+ match.getTeam1() + " vs " + match.getTeam2() + System.lineSeparator());
				lstTeamsPlayed.add(match.getTeam1());
				lstTeamsPlayed.add(match.getTeam2());

				if (lstTeamsPlayed.size() == 8)

					for (int i = 0; i < 4; i++)
						lstTeamsPlayed.remove(0);
				matchCount++;
				lstMatches.remove(match);
			}

			else {

				lstTeamsPlayed.add(null);
				lstTeamsPlayed.add(null);
				if (lstTeamsPlayed.size() == 8) {

					for (int i = 0; i < 4; i++)
						lstTeamsPlayed.remove(0);

				}
				matchCount++;

			}

		}

		return sb.toString();
	}



	static List<Match> ListMatches(List<String> ListTeam) {

		List<Match> lstMatches = new ArrayList<>();

		for (int i = 0; i < ListTeam.size(); i++) {

			String team1 = ListTeam.get(0);
			for (int j = 1; j < ListTeam.size(); j++) {
				lstMatches.add(new Match(team1, ListTeam.get(j)));
				//System.out.println(team1 + " vs " + ListTeam.get(j));
			}
			ListTeam.remove(0);
			ListTeam.add(team1);

		}
		
		Collections.shuffle(lstMatches);
		return lstMatches;

	}

}
