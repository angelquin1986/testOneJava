package com.ec.qsof.demo;

public class Boat {
   public Boat(String ship_id, Integer missionsSize) {
      this.ship_id = ship_id;
      this.missionsSize = missionsSize;
   }

   private String ship_id;
   private Integer missionsSize;

   public String getShip_id() {
      return ship_id;
   }

   public void setShip_id(String ship_id) {
      this.ship_id = ship_id;
   }

   public Integer getMissionsSize() {
      return missionsSize;
   }

   public void setMissionsSize(Integer missionsSize) {
      this.missionsSize = missionsSize;
   }
}
