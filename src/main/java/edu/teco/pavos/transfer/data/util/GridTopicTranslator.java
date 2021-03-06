package edu.teco.pavos.transfer.data.util;

import edu.teco.pavos.core.grid.config.Seperators;

/**
 * A utility class to generate foldernames for graphite.
 * Each folder is seperated by a dot.
 */
public final class GridTopicTranslator {
	
	private static final String POINT = ".";
	
	private GridTopicTranslator() {
		
	}
	
	/**
	 * Assembles a {@link String} topic with a folder-like structure.
	 * @param sensorID {@link String}
	 * @param gridClusterCombinationID {@link String}
	 * @return topic {@link String}
	 */
	public static String getTopic(String sensorID, String gridClusterCombinationID) {
		StringBuilder topicBuilder = new StringBuilder();
		String[] args = gridClusterCombinationID.split(Seperators.GRID_CLUSTER_SEPERATOR);
		String gridID = args[0];
		String[] clusters = args[1].split(Seperators.CLUSTER_SEPERATOR);
		
		topicBuilder.append(gridID + POINT);
		for (int i = 0; i < clusters.length; i++) {
			topicBuilder.append(clusters[i]);
			topicBuilder.append(POINT);
		}
		String base = topicBuilder.toString();
		return base + sensorID;
	}
	
}
