/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storagecalculator;

import java.io.Serializable;

public class VideoStorage implements Serializable {
	
	//video properties needed to calculate storage
	private int seconds;
	private int videoQuality;
	//variables to store calculated size
	private double sizeMB;
	private double sizeGB;
	
	//no-arg constructor
	public VideoStorage() {
	}
	
	//constructor for seconds and quality inputs
	public VideoStorage(int seconds, int videoQuality) {
		this.seconds = seconds;
		this.videoQuality = videoQuality;
	}

	//getter/setter for seconds
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	//getter/setter for quality
	public int getVideoQuality() {
		return videoQuality;
	}

	public void setVideoQuality(int videoQuality) {
		this.videoQuality = videoQuality;
	}
	
	/*
	720p video conversion: 100MB/minute
	1080p video conversion: 210MB/minute
		per website: https://www.dpreview.com/forums/thread/3048884
	*/
	
	private double calcStorageMB(){
		if(videoQuality == 720){
			sizeMB = seconds * 1.6667;
		}else if(videoQuality == 1080){
			sizeMB = seconds * 3.5;
		}
		return sizeMB;
	}
	
	private double calcStorageGB(){
		if(videoQuality == 720){
			sizeGB = (seconds * 1.6667) / 1000;
		}else if(videoQuality == 1080){
			sizeGB = (seconds * 3.5) / 1000;
		}
		return sizeGB;
	}
	
	//single method to call MB and GB calculations and return result as a String to be displayed by independent program
	public String calcStorage(){
		String result = String.format("This video will require %4.2fMB, or %4.2fGB.", calcStorageMB(), calcStorageGB());
		return result;
	}

	@Override
	public String toString() {
		return "VideoStorage [seconds=" + seconds + ", videoQuality=" + videoQuality + "]";
	}

}
