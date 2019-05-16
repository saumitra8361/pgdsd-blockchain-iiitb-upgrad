package com.upgrad.ecommerce.domain.v3;

import java.util.Date;

public class ProductV3 extends StorableWebObject {

  private String name;
  private BrandV3 brand;
  private String description;
  private Date dateLaunched;

  public ProductV3(BrandV3 brand, String name) {
    super(name);
    this.name = name;
    this.brand = brand;
  }
  
  public String getName() {
    return name;
  }

  public BrandV3 getBrand() {
    return brand;
  }
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDateLaunched() {
    return dateLaunched;
  }

  public void setDateLaunched(Date dateLaunched) {
    this.dateLaunched = dateLaunched;
  }
  
  @Override
  protected void generateUUID() {
    this.uuid = this.brand.getUUID() + "-" + this.name.replaceAll(" ", "-");
  }

  @Override
  public void preUpdate() {
    super.generateUUID();
    super.updateLastUpdated();
  }

  @Override
  public void preInsert() {
    super.generateUUID();
    super.updateLastUpdated();
  }
}
