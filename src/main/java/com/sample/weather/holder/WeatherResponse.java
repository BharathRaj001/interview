package com.sample.weather.holder;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class WeatherResponse implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
		 * 
		 */
	//	private static final long serialVersionUID = -9079108590474178565L;
		public Coord coord;
	    public List<WeatherData> weather;
	    public String base;
	    public Main main;
	    public int visibility;
	    public Wind wind;
	    public Clouds clouds;
	    public Long dt;
	    public Sys sys;
	    public Long id;
	    public String name;
	    public Double cod;
	    
	    @Data
	    @NoArgsConstructor
	    public static class WeatherData implements Serializable{
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			/**
			 * 
			 */
			//private static final long serialVersionUID = -158124002826244464L;
			public Long id;
	        public String main;
	        public String description;
	        public String icon;
	    }
	    @Data
	    public class Sys implements Serializable{
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			/**
			 * 
			 */
			//private static final long serialVersionUID = -1783521743836320878L;
			public int type;
	        public Long id;
	        public Double message;
	        public String country;
	        public Long sunrise;
	        public Long sunset;
	    }
	    @Data
	    public class Coord implements Serializable{
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			/**
			 * 
			 */
			//private static final long serialVersionUID = 5880402856606610508L;
			public Double lon;
	        public Double lat;
	    }
	    @Data
	    public class Main implements Serializable{ 
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			/**
			 * 
			 */
		//	private static final long serialVersionUID = 8918417954032011437L;
			public Double temp;
	        public Double pressure;
	        public Double humidity;
	        public Double temp_min;
	        public Double temp_max;
	    }
	    @Data
	    public class Wind implements Serializable{
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public Double speed;
	        public Double deg;
	    }
	    @Data
	    public class Clouds implements Serializable{
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public Double all;
	    }
	   
}
