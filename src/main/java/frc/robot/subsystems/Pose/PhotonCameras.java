package frc.robot.subsystems.Pose;

import java.util.Optional;

import org.photonvision.EstimatedRobotPose;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonCameras extends SubsystemBase {

  // Field
  public static final AprilTagFieldLayout kTagLayout = AprilTagFieldLayout.loadField(AprilTagFields.k2025ReefscapeAndyMark);

  // Camera Positions (Distance Away in Metres & Rotation in Radians)
  public static final Transform3d kfLCameraPose = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0, 0, 0));

  // Cameras
  private final PhotonCamera fLCamera = new PhotonCamera("fLCamera-10316");

  private final PhotonPoseEstimator fLphotonPoseEstimator = new PhotonPoseEstimator(kTagLayout, PoseStrategy.MULTI_TAG_PNP_ON_COPROCESSOR, kfLCameraPose);

  

    public PhotonCameras() {
      
    }

  public Command exampleMethodCommand() {
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public boolean exampleCondition() {
    return false;
  }

  @Override
  public void periodic() {
    Optional<EstimatedRobotPose> visionEst = Optional.empty();
      for (var change : fLCamera.getAllUnreadResults()) {
        visionEst = fLphotonPoseEstimator.update(change);
        
      }
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
