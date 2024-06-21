# Set the path to the directory containing the JAR files
$libPath = "C:\Users\Lari\Desktop\libs"

# Set the paths to the JAR files
$algs4JarPath = "$libPath\algs4.jar"
$junitJarPath = "$libPath\junit-4.13.1.jar"

# Set the path to the Java source file
$javaSourcePath = "C:\Users\Lari\Desktop\UNI\ADP\src\Praktikum3\ad_2_5\BottomK.java"

# Set the classpath for Java
$classpath = ".;$algs4JarPath;$junitJarPath"

# Compile the Java file
Write-Host "Compiling Java source file: $javaSourcePath"
javac -cp $classpath $javaSourcePath

# Check if the compilation was successful
if ($?) {
    Write-Host "Compilation successful. Running the program..."
    # Run the Java program
    java -cp $classpath Praktikum3.ad_2_5.BottomK
} else {
    Write-Error "Compilation failed."
}
