import cv2

def convert_to_gray(image_filename):
    # Read the image from the same folder
    original_image = cv2.imread(image_filename)

    if original_image is None:
        print("Error: Unable to read the image.")
        return

    # Convert the image to grayscale
    gray_image = cv2.cvtColor(original_image, cv2.COLOR_BGR2GRAY)

    # Display the original and grayscale images
    cv2.imshow("Original Image", original_image)
    cv2.imshow("Gray Image", gray_image)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    # Save the grayscale image
    cv2.imwrite("gray_image.jpg", gray_image)

def convert_to_color(gray_image_filename):
    # Read the grayscale image from the same folder
    gray_image = cv2.imread(gray_image_filename, cv2.IMREAD_GRAYSCALE)

    if gray_image is None:
        print("Error: Unable to read the grayscale image.")
        return

    # Convert the grayscale image to color
    color_image = cv2.cvtColor(gray_image, cv2.COLOR_GRAY2BGR)

    # Display the grayscale and original color images
    cv2.imshow("Gray Image", gray_image)
    cv2.imshow("Color Image", color_image)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    # Save the color image
    cv2.imwrite("color_image.jpg", color_image)

# Example usage:
# Assuming the image is in the same folder as your script
# Convert image to grayscale
convert_to_gray("eagle_color.jpg")

# Convert grayscale image back to color
convert_to_color("albert-einstein.jpg")


# https://www.youtube.com/watch?v=gAmskBNz_Vc