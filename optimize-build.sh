#!/bin/bash
# AuraOS Build Optimization Script
# Optimized for Java 24, Kotlin 2.2.0, AGP 8.11.1, Gradle 8.14.3

echo "🚀 AuraOS Build Optimization Suite"
echo "===================================="

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m'

log_info() {
    echo -e "${BLUE}ℹ️  $1${NC}"
}

log_success() {
    echo -e "${GREEN}✅ $1${NC}"
}

# Function to check system requirements
check_requirements() {
    log_info "Checking system requirements..."
    
    if command -v java >/dev/null 2>&1; then
        JAVA_VERSION=$(java -version 2>&1 | head -n1 | cut -d'"' -f2 | cut -d'.' -f1)
        log_success "Java $JAVA_VERSION detected"
    else
        echo "❌ Java not found in PATH"
        exit 1
    fi
}

# Build performance test
performance_test() {
    log_info "Running build performance test..."
    
    start_time=$(date +%s)
    
    if ./gradlew clean build --configuration-cache --parallel; then
        end_time=$(date +%s)
        duration=$((end_time - start_time))
        minutes=$((duration / 60))
        seconds=$((duration % 60))
        
        log_success "Build completed in ${minutes}m ${seconds}s"
    else
        echo "❌ Build failed. Check configuration."
        return 1
    fi
}

# Main execution
case "$1" in
    "--performance-test")
        check_requirements
        performance_test
        ;;
    "--full")
        check_requirements
        performance_test
        ;;
    *)
        log_info "Available options:"
        echo "  --performance-test   Run build performance test"
        echo "  --full              Run complete optimization suite"
        ;;
esac

log_success "AuraOS optimization complete! 🎉"
