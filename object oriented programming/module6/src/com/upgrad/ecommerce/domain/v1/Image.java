/** Package to which this class belongs to **/
package com.upgrad.ecommerce.domain.v1;

/** Image class declaration **/
public class Image {

  /** Instance variables **/
  private String imgLoc;
  private String imgDesc;
  private int dimensionX;
  private int dimensionY;
  private boolean defaultImg;

  /** Getter method for image location **/
  public String getImgLoc() {
    return imgLoc;
  }

  /** Setter method for image location **/
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
