package edu.teco.pavos.core.grid.geojson.data;

import java.util.Collection;

import edu.teco.pavos.core.grid.geojson.GeoJsonBuilder;

/**
 * The GeoJson format for an observation.
 */
public class ObservationGeoJson {
	
	private final String geoJson;
	
	/**
	 * Creates a new {@link ObservationGeoJson}.
	 * @param timestamp The time of the observation
	 * @param observationType The type of the observation
	 * @param features The features of the observation
	 */
	public ObservationGeoJson(String timestamp, String observationType, Collection<String> features) {
		this.geoJson = buildGeoJson(timestamp, observationType, features);
	}
	
	private String buildGeoJson(String timestamp, String observationType, Collection<String> features) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append(String.join(",", GeoJsonBuilder.toSProperty("type", "FeatureCollection"),
				GeoJsonBuilder.toSProperty("timestamp", timestamp),
				GeoJsonBuilder.toSProperty("observationType", observationType),
				GeoJsonBuilder.toEntry("features") + ":" + features.toString()));
		builder.append("}");
		return builder.toString();
	}
	
	/**
	 * @return the geoJson
	 */
	public String getGeoJson() {
		return geoJson;
	}
	
}
