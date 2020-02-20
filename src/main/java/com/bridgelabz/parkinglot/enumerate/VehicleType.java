package com.bridgelabz.parkinglot.enumerate;

import com.bridgelabz.parkinglot.services.SlotNumber;

public enum VehicleType {
    ADAPTED_VEHICLE {
        @Override
        public Integer getSlotNumber(SlotNumber slotNumber) {
            return slotNumber.getHandicapSlotNumber();
        }
    }, LARGE_VEHICLE {
        @Override
        public Integer getSlotNumber(SlotNumber slotNumber) {
            return slotNumber.getLargeVehicleSlotNumber();
        }
    }, SMALL_VEHICLE {
        @Override
        public Integer getSlotNumber(SlotNumber slotNumber) {
            return slotNumber.getNonHandicapSlotNumber();
        }
    };

    public abstract Integer getSlotNumber(SlotNumber slotNumber);
}