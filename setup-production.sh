#!/bin/bash
# AuraOS Production Setup Script
# Run this on your local machine with Java 24

echo "🚀 AuraOS Production Environment Setup"
echo "======================================"

# Check if running with Java 24
JAVA_VERSION=$(java -version 2>&1 | head -n1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 24 ]; then
    echo "❌ This script requires Java 24+"
    echo "   Current Java version: $JAVA_VERSION"
    echo "   Please install Java 24 and set JAVA_HOME"
    exit 1
fi

echo "✅ Java $JAVA_VERSION detected"

# Create development quick commands
cat > build-commands.sh << 'CMD_EOF'
#!/bin/bash
# AuraOS Build Commands

echo "🛠️  AuraOS Build Commands"
echo "======================"

case "$1" in
    "dev")
        echo "🔧 Development build..."
        ./gradlew build --configuration-cache
        ;;
    "prod")
        echo "🚀 Production build..."
        ./gradlew build --configuration-cache --parallel
        ;;
    "clean")
        echo "🧹 Clean build..."
        ./gradlew clean build --configuration-cache
        ;;
    "test")
        echo "🧪 Running tests..."
        ./gradlew test --configuration-cache --parallel
        ;;
    "perf")
        echo "📊 Performance test..."
        time ./gradlew build --configuration-cache --parallel --scan
        ;;
    *)
        echo "Available commands:"
        echo "  ./build-commands.sh dev     # Fast development build"
        echo "  ./build-commands.sh prod    # Production build"
        echo "  ./build-commands.sh clean   # Clean build"
        echo "  ./build-commands.sh test    # Run tests"
        echo "  ./build-commands.sh perf    # Performance test"
        ;;
esac
CMD_EOF

chmod +x build-commands.sh
echo "✅ Build commands script created"
echo "🎉 Production Setup Complete!"
