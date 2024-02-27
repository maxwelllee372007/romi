#!/usr/bin/env pybricks-micropython
from pybricks.hubs import EV3Brick
from pybricks.ev3devices import Motor
from pybricks.parameters import Port
from pybricks.robotics import DriveBase

# Create your objects here

# Initialize the EV3 Brick.
ev3 = EV3Brick()

# Initialize a motor at port B.
left_motor = Motor(Port.B)
right_motor = Motor(Port.A)

drivetrain = DriveBase(left_motor,right_motor,wheel_diameter=50,axle_track=113.2)

# Write your program here

# Play a sound.
ev3.speaker.beep()

# Run the motor up to 500 degrees per second. To a target angle of 90 degrees.
drivetrain.straight(1000)
print(drivetrain.state())

# Play another beep sound.
#ev3.speaker.beep(frequency=1000, duration=5000)