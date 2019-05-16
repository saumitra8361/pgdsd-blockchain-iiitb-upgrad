package com.upgrad.ecommerce.domain.v3;

public class Image {

  private String imgLoc;
  private String imgDesc;
  private int dimensionX;
  private int dimensionY;
  private boolean defaultImg;

  public String getImgLoc() {
    return imgLoc;
  }

  public void setImgLoc(String imgLoc) {
    this.imgLoc = imgLoc;
  }

  public String getImgDesc() {
    return imgDesc;
  }

  public void setImgDesc(String imgDesc) {
    this.imgDesc = imgDesc;
  }

  public int getDimensionX() {
    return dimensionX;
  }

  public void setDimensionX(int dimensionX) {
    this.dimensionX = dimensionX;
  }

  public int getDimensionY() {
    return dimensionY;
  }

  public void setDimensionY(int dimensionY) {
    this.dimensionY = dimensionY;
  }

  public boolean isDefaultImg() {
    return defaultImg;
  }

  public void setDefaultImg(boolean defaultImg) {
    this.defaultImg = defaultImg;
  }
}
