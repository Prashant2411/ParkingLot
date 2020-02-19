package com.bridgelabz.parkinglot.enumerate;

import com.bridgelabz.parkinglot.services.SlotNumber;

public enum DriverType {
    HANDICAP_DRIVER{
        @Override
        public Integer getSlotNumber(SlotNumber slotNumber) {
            return slotNumber.getHandicapSlotNumber();
        }
    }, LARGE_VEHICLE_DRIVER{
        @Override
        public Integer getSlotNumber(SlotNumber slotNumber) {
            return slotNumber.getLargeVehicleSlotNumber();
        }
    }, NORMAL_VEHICLE_DRIVER{
        @Override
        public Integer getSlotNumber(SlotNumber slotNumber) {
            return slotNumber.getNonHandicapSlotNumber();
        }
    };

    public abstract Integer getSlotNumber(SlotNumber slotNumber);
}