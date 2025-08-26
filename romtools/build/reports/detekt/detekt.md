# detekt

## Metrics

* 22 number of properties

* 64 number of functions

* 54 number of classes

* 4 number of packages

* 6 number of kt files

## Complexity Report

* 1,162 lines of code (loc)

* 913 source lines of code (sloc)

* 707 logical lines of code (lloc)

* 110 comment lines of code (cloc)

* 112 cyclomatic complexity (mcc)

* 66 cognitive complexity

* 71 number of total code smells

* 12% comment source ratio

* 158 mcc per 1,000 lloc

* 100 code smells per 1,000 lloc

## Findings (71)

### complexity, LongMethod (1)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer
smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:32:5

```
The function RomToolsScreen is too long (128). The maximum length is 60.
```

```kotlin
29  */
30 @OptIn(ExperimentalMaterial3Api::class)
31 @Composable
32 fun RomToolsScreen(
!!     ^ error
33     modifier: Modifier = Modifier,
34     romToolsManager: RomToolsManager = hiltViewModel()
35 ) {

```

### complexity, LongParameterList (1)

The more parameters a function has the more complex it is. Long parameter lists are often used to
control complex algorithms and violate the Single Responsibility Principle. Prefer functions with
short parameter lists.

[Documentation](https://detekt.dev/docs/rules/complexity#longparameterlist)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:28:42

```
The constructor(context: Context, bootloaderManager: BootloaderManager, recoveryManager: RecoveryManager, systemModificationManager: SystemModificationManager, flashManager: FlashManager, verificationManager: RomVerificationManager, backupManager: BackupManager) has too many parameters. The current threshold is set to 7.
```

```kotlin
25  * - AI-assisted ROM optimization
26  */
27 @Singleton
28 class RomToolsManager @Inject constructor(
!!                                          ^ error
29     @ApplicationContext private val context: Context,
30     private val bootloaderManager: BootloaderManager,
31     private val recoveryManager: RecoveryManager,

```

### complexity, TooManyFunctions (1)

Too many functions inside a/an file/class/object/interface always indicate a violation of the single
responsibility principle. Maybe the file/class/object/interface wants to manage too many things at
once. Extract functionality which clearly belongs together.

[Documentation](https://detekt.dev/docs/rules/complexity#toomanyfunctions)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:28:7

```
Class 'RomToolsManager' with '11' functions detected. Defined threshold inside classes is set to '11'
```

```kotlin
25  * - AI-assisted ROM optimization
26  */
27 @Singleton
28 class RomToolsManager @Inject constructor(
!!       ^ error
29     @ApplicationContext private val context: Context,
30     private val bootloaderManager: BootloaderManager,
31     private val recoveryManager: RecoveryManager,

```

### empty-blocks, EmptyElseBlock (1)

Empty block of code detected. As they serve no purpose they should be removed.

[Documentation](https://detekt.dev/docs/rules/empty-blocks#emptyelseblock)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:328:47

```
This empty block of code can be removed.
```

```kotlin
325 ) {
326     Card(
327         modifier = modifier.fillMaxWidth(),
328         onClick = if (isEnabled) onClick else {
!!!                                               ^ error
329         },
330         colors = CardDefaults.cardColors(
331             containerColor = if (isEnabled) Color(0xFF1E1E1E) else Color(0xFF111111)

```

### exceptions, SwallowedException (1)

The caught exception is swallowed. The original exception could be lost.

[Documentation](https://detekt.dev/docs/rules/exceptions#swallowedexception)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:236:18

```
The caught exception is swallowed. The original exception could be lost.
```

```kotlin
233         return try {
234             val process = Runtime.getRuntime().exec("su -c 'echo test'")
235             process.waitFor() == 0
236         } catch (e: Exception) {
!!!                  ^ error
237             false
238         }
239     }

```

### exceptions, TooGenericExceptionCaught (6)

The caught exception is too generic. Prefer catching specific exceptions to the case that is
currently handled.

[Documentation](https://detekt.dev/docs/rules/exceptions#toogenericexceptioncaught)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:118:18

```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```

```kotlin
115             Timber.i("ROM flashed successfully: ${romFile.name}")
116             Result.success(Unit)
117 
118         } catch (e: Exception) {
!!!                  ^ error
119             Timber.e(e, "Failed to flash ROM: ${romFile.name}")
120             updateOperationProgress(RomOperation.FAILED, 0f)
121             clearOperationProgress()

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:143:18

```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```

```kotlin
140             Timber.i("NANDroid backup created: $backupName")
141             Result.success(backupInfo)
142 
143         } catch (e: Exception) {
!!!                  ^ error
144             Timber.e(e, "Failed to create NANDroid backup: $backupName")
145             updateOperationProgress(RomOperation.FAILED, 0f)
146             clearOperationProgress()

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:168:18

```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```

```kotlin
165             Timber.i("NANDroid backup restored: ${backupInfo.name}")
166             Result.success(Unit)
167 
168         } catch (e: Exception) {
!!!                  ^ error
169             Timber.e(e, "Failed to restore NANDroid backup: ${backupInfo.name}")
170             updateOperationProgress(RomOperation.FAILED, 0f)
171             clearOperationProgress()

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:193:18

```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```

```kotlin
190             Timber.i("Genesis AI optimizations installed successfully")
191             Result.success(Unit)
192 
193         } catch (e: Exception) {
!!!                  ^ error
194             Timber.e(e, "Failed to install Genesis optimizations")
195             updateOperationProgress(RomOperation.FAILED, 0f)
196             clearOperationProgress()

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:210:18

```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```

```kotlin
207             val deviceModel = _romToolsState.value.capabilities?.deviceModel ?: "unknown"
208             val roms = romRepository.getCompatibleRoms(deviceModel)
209             Result.success(roms)
210         } catch (e: Exception) {
!!!                  ^ error
211             Timber.e(e, "Failed to get available ROMs")
212             Result.failure(e)
213         }

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:236:18

```
The caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.
```

```kotlin
233         return try {
234             val process = Runtime.getRuntime().exec("su -c 'echo test'")
235             process.waitFor() == 0
236         } catch (e: Exception) {
!!!                  ^ error
237             false
238         }
239     }

```

### naming, FunctionNaming (8)

Function names should follow the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionnaming)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:32:5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
29  */
30 @OptIn(ExperimentalMaterial3Api::class)
31 @Composable
32 fun RomToolsScreen(
!!     ^ error
33     modifier: Modifier = Modifier,
34     romToolsManager: RomToolsManager = hiltViewModel()
35 ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:194:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
191 }
192 
193 @Composable
194 private fun DeviceCapabilitiesCard(
!!!             ^ error
195     capabilities: dev.aurakai.auraframefx.romtools.RomCapabilities?,
196     modifier: Modifier = Modifier
197 ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:239:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
236 }
237 
238 @Composable
239 private fun CapabilityRow(label: String, hasCapability: Boolean) {
!!!             ^ error
240     Row(
241         modifier = Modifier.fillMaxWidth(),
242         horizontalArrangement = Arrangement.SpaceBetween,

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:260:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
257 }
258 
259 @Composable
260 private fun InfoRow(label: String, value: String) {
!!!             ^ error
261     Row(
262         modifier = Modifier.fillMaxWidth(),
263         horizontalArrangement = Arrangement.SpaceBetween

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:280:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
277 }
278 
279 @Composable
280 private fun OperationProgressCard(
!!!             ^ error
281     operation: dev.aurakai.auraframefx.romtools.OperationProgress,
282     modifier: Modifier = Modifier
283 ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:320:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
317 }
318 
319 @Composable
320 private fun RomToolActionCard(
!!!             ^ error
321     action: RomToolAction,
322     isEnabled: Boolean,
323     onClick: () -> Unit,

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:468:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
465 }
466 
467 @Composable
468 private fun AvailableRomCard(rom: dev.aurakai.auraframefx.romtools.AvailableRom) {
!!!             ^ error
469     // Implementation for available ROM card
470 }
471 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:473:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
470 }
471 
472 @Composable
473 private fun BackupCard(backup: dev.aurakai.auraframefx.romtools.BackupInfo) {
!!!             ^ error
474     // Implementation for backup card
475 }
476 

```

### style, ForbiddenComment (3)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/bootloader/BootloaderManager.kt:22:9

```
Forbidden TODO todo marker in comment, please do the changes.
```

```kotlin
19 @Singleton
20 class BootloaderManagerImpl @Inject constructor() : BootloaderManager {
21     override fun checkBootloaderAccess(): Boolean {
22         // TODO: Implement bootloader access check
!!         ^ error
23         return false
24     }
25 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/bootloader/BootloaderManager.kt:27:9

```
Forbidden TODO todo marker in comment, please do the changes.
```

```kotlin
24     }
25 
26     override fun isBootloaderUnlocked(): Boolean {
27         // TODO: Implement bootloader unlock status check
!!         ^ error
28         return false
29     }
30 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/bootloader/BootloaderManager.kt:32:9

```
Forbidden TODO todo marker in comment, please do the changes.
```

```kotlin
29     }
30 
31     override suspend fun unlockBootloader(): Result<Unit> {
32         // TODO: Implement bootloader unlock
!!         ^ error
33         return Result.failure(Exception("Not implemented"))
34     }
35 }

```

### style, MagicNumber (40)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence
it's unclear what the purpose of this number is. It's better to declare such numbers as constants
and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsConfig.kt:15:56

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
12     const val ROM_TOOLS_ENABLED: Boolean = true
13 
14     /** Supported Android versions for ROM manipulation */
15     val SUPPORTED_ANDROID_VERSIONS: List<Int> = listOf(13, 14, 15, 16)
!!                                                        ^ error
16 
17     /** Supported CPU architectures */
18     val SUPPORTED_ARCHITECTURES: List<String> = listOf(

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsConfig.kt:15:60

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
12     const val ROM_TOOLS_ENABLED: Boolean = true
13 
14     /** Supported Android versions for ROM manipulation */
15     val SUPPORTED_ANDROID_VERSIONS: List<Int> = listOf(13, 14, 15, 16)
!!                                                            ^ error
16 
17     /** Supported CPU architectures */
18     val SUPPORTED_ARCHITECTURES: List<String> = listOf(

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsConfig.kt:15:64

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
12     const val ROM_TOOLS_ENABLED: Boolean = true
13 
14     /** Supported Android versions for ROM manipulation */
15     val SUPPORTED_ANDROID_VERSIONS: List<Int> = listOf(13, 14, 15, 16)
!!                                                                ^ error
16 
17     /** Supported CPU architectures */
18     val SUPPORTED_ARCHITECTURES: List<String> = listOf(

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsConfig.kt:15:68

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
12     const val ROM_TOOLS_ENABLED: Boolean = true
13 
14     /** Supported Android versions for ROM manipulation */
15     val SUPPORTED_ANDROID_VERSIONS: List<Int> = listOf(13, 14, 15, 16)
!!                                                                    ^ error
16 
17     /** Supported CPU architectures */
18     val SUPPORTED_ARCHITECTURES: List<String> = listOf(

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:81:65

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
78             updateOperationProgress(RomOperation.FLASHING_ROM, 0f)
79 
80             // Step 1: Verify ROM file integrity
81             updateOperationProgress(RomOperation.VERIFYING_ROM, 10f)
!!                                                                 ^ error
82             verificationManager.verifyRomFile(romFile).getOrThrow()
83 
84             // Step 2: Create backup if requested

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:86:71

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
83 
84             // Step 2: Create backup if requested
85             if (_romToolsState.value.settings.autoBackup) {
86                 updateOperationProgress(RomOperation.CREATING_BACKUP, 20f)
!!                                                                       ^ error
87                 backupManager.createFullBackup().getOrThrow()
88             }
89 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:92:76

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
89 
90             // Step 3: Unlock bootloader if needed
91             if (!bootloaderManager.isBootloaderUnlocked()) {
92                 updateOperationProgress(RomOperation.UNLOCKING_BOOTLOADER, 30f)
!!                                                                            ^ error
93                 bootloaderManager.unlockBootloader().getOrThrow()
94             }
95 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:98:75

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
95  
96              // Step 4: Install custom recovery if needed
97              if (!recoveryManager.isCustomRecoveryInstalled()) {
98                  updateOperationProgress(RomOperation.INSTALLING_RECOVERY, 40f)
!!                                                                            ^ error
99                  recoveryManager.installCustomRecovery().getOrThrow()
100             }
101 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:103:64

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
100             }
101 
102             // Step 5: Flash ROM
103             updateOperationProgress(RomOperation.FLASHING_ROM, 50f)
!!!                                                                ^ error
104             flashManager.flashRom(romFile) { progress ->
105                 updateOperationProgress(RomOperation.FLASHING_ROM, 50f + (progress * 40f))
106             }.getOrThrow()

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:105:68

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
102             // Step 5: Flash ROM
103             updateOperationProgress(RomOperation.FLASHING_ROM, 50f)
104             flashManager.flashRom(romFile) { progress ->
105                 updateOperationProgress(RomOperation.FLASHING_ROM, 50f + (progress * 40f))
!!!                                                                    ^ error
106             }.getOrThrow()
107 
108             // Step 6: Verify installation

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:105:86

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
102             // Step 5: Flash ROM
103             updateOperationProgress(RomOperation.FLASHING_ROM, 50f)
104             flashManager.flashRom(romFile) { progress ->
105                 updateOperationProgress(RomOperation.FLASHING_ROM, 50f + (progress * 40f))
!!!                                                                                      ^ error
106             }.getOrThrow()
107 
108             // Step 6: Verify installation

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:109:74

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
106             }.getOrThrow()
107 
108             // Step 6: Verify installation
109             updateOperationProgress(RomOperation.VERIFYING_INSTALLATION, 90f)
!!!                                                                          ^ error
110             verificationManager.verifyInstallation().getOrThrow()
111 
112             updateOperationProgress(RomOperation.COMPLETED, 100f)

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:112:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
109             updateOperationProgress(RomOperation.VERIFYING_INSTALLATION, 90f)
110             verificationManager.verifyInstallation().getOrThrow()
111 
112             updateOperationProgress(RomOperation.COMPLETED, 100f)
!!!                                                             ^ error
113             clearOperationProgress()
114 
115             Timber.i("ROM flashed successfully: ${romFile.name}")

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:137:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
134                 updateOperationProgress(RomOperation.CREATING_BACKUP, progress)
135             }.getOrThrow()
136 
137             updateOperationProgress(RomOperation.COMPLETED, 100f)
!!!                                                             ^ error
138             clearOperationProgress()
139 
140             Timber.i("NANDroid backup created: $backupName")

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:162:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
159                 updateOperationProgress(RomOperation.RESTORING_BACKUP, progress)
160             }.getOrThrow()
161 
162             updateOperationProgress(RomOperation.COMPLETED, 100f)
!!!                                                             ^ error
163             clearOperationProgress()
164 
165             Timber.i("NANDroid backup restored: ${backupInfo.name}")

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:187:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
184                 updateOperationProgress(RomOperation.APPLYING_OPTIMIZATIONS, progress)
185             }.getOrThrow()
186 
187             updateOperationProgress(RomOperation.COMPLETED, 100f)
!!!                                                             ^ error
188             clearOperationProgress()
189 
190             Timber.i("Genesis AI optimizations installed successfully")

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:45:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
42             .background(
43                 brush = androidx.compose.ui.graphics.Brush.verticalGradient(
44                     colors = listOf(
45                         Color(0xFF0A0A0A),
!!                               ^ error
46                         Color(0xFF1A1A1A),
47                         Color(0xFF0A0A0A)
48                     )

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:46:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
43                 brush = androidx.compose.ui.graphics.Brush.verticalGradient(
44                     colors = listOf(
45                         Color(0xFF0A0A0A),
46                         Color(0xFF1A1A1A),
!!                               ^ error
47                         Color(0xFF0A0A0A)
48                     )
49                 )

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:47:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
44                     colors = listOf(
45                         Color(0xFF0A0A0A),
46                         Color(0xFF1A1A1A),
47                         Color(0xFF0A0A0A)
!!                               ^ error
48                     )
49                 )
50             )

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:57:35

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
54             title = {
55                 Text(
56                     text = "ROM Tools",
57                     color = Color(0xFFFF6B35),
!!                                   ^ error
58                     fontWeight = FontWeight.Bold,
59                     fontSize = 20.sp
60                 )

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:78:39

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
75                     verticalArrangement = Arrangement.spacedBy(16.dp)
76                 ) {
77                     CircularProgressIndicator(
78                         color = Color(0xFFFF6B35),
!!                                       ^ error
79                         strokeWidth = 3.dp
80                     )
81                     Text(

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:112:39

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
109                 item {
110                     Text(
111                         text = "ROM Operations",
112                         color = Color(0xFFFF6B35),
!!!                                       ^ error
113                         fontSize = 18.sp,
114                         fontWeight = FontWeight.Bold,
115                         modifier = Modifier.padding(vertical = 8.dp)

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:160:43

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
157                     item {
158                         Text(
159                             text = "Available ROMs",
160                             color = Color(0xFFFF6B35),
!!!                                           ^ error
161                             fontSize = 18.sp,
162                             fontWeight = FontWeight.Bold,
163                             modifier = Modifier.padding(vertical = 8.dp)

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:177:43

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
174                     item {
175                         Text(
176                             text = "Backups",
177                             color = Color(0xFFFF6B35),
!!!                                           ^ error
178                             fontSize = 18.sp,
179                             fontWeight = FontWeight.Bold,
180                             modifier = Modifier.padding(vertical = 8.dp)

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:201:36

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
198     Card(
199         modifier = modifier.fillMaxWidth(),
200         colors = CardDefaults.cardColors(
201             containerColor = Color(0xFF1E1E1E)
!!!                                    ^ error
202         ),
203         shape = RoundedCornerShape(12.dp)
204     ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:211:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
208         ) {
209             Text(
210                 text = "Device Capabilities",
211                 color = Color(0xFFFF6B35),
!!!                               ^ error
212                 fontSize = 16.sp,
213                 fontWeight = FontWeight.Bold
214             )

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:253:45

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
250         Icon(
251             imageVector = if (hasCapability) Icons.Default.CheckCircle else Icons.Default.Cancel,
252             contentDescription = null,
253             tint = if (hasCapability) Color(0xFF4CAF50) else Color(0xFFF44336),
!!!                                             ^ error
254             modifier = Modifier.size(20.dp)
255         )
256     }

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:253:68

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
250         Icon(
251             imageVector = if (hasCapability) Icons.Default.CheckCircle else Icons.Default.Cancel,
252             contentDescription = null,
253             tint = if (hasCapability) Color(0xFF4CAF50) else Color(0xFFF44336),
!!!                                                                    ^ error
254             modifier = Modifier.size(20.dp)
255         )
256     }

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:287:36

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
284     Card(
285         modifier = modifier.fillMaxWidth(),
286         colors = CardDefaults.cardColors(
287             containerColor = Color(0xFF2E2E2E)
!!!                                    ^ error
288         ),
289         shape = RoundedCornerShape(12.dp)
290     ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:297:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
294         ) {
295             Text(
296                 text = operation.operation.getDisplayName(),
297                 color = Color(0xFFFF6B35),
!!!                               ^ error
298                 fontSize = 16.sp,
299                 fontWeight = FontWeight.Bold
300             )

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:305:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
302             LinearProgressIndicator(
303                 progress = operation.progress / 100f,
304                 modifier = Modifier.fillMaxWidth(),
305                 color = Color(0xFFFF6B35),
!!!                               ^ error
306                 trackColor = Color(0xFF444444)
307             )
308 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:306:36

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
303                 progress = operation.progress / 100f,
304                 modifier = Modifier.fillMaxWidth(),
305                 color = Color(0xFFFF6B35),
306                 trackColor = Color(0xFF444444)
!!!                                    ^ error
307             )
308 
309             Text(

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:331:51

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
328         onClick = if (isEnabled) onClick else {
329         },
330         colors = CardDefaults.cardColors(
331             containerColor = if (isEnabled) Color(0xFF1E1E1E) else Color(0xFF111111)
!!!                                                   ^ error
332         ),
333         shape = RoundedCornerShape(12.dp)
334     ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:331:74

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
328         onClick = if (isEnabled) onClick else {
329         },
330         colors = CardDefaults.cardColors(
331             containerColor = if (isEnabled) Color(0xFF1E1E1E) else Color(0xFF111111)
!!!                                                                          ^ error
332         ),
333         shape = RoundedCornerShape(12.dp)
334     ) {

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:385:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
382             title = "Flash Custom ROM",
383             description = "Install a custom ROM on your device",
384             icon = Icons.Default.FlashOn,
385             color = Color(0xFFFF6B35),
!!!                           ^ error
386             requiresRoot = true,
387             requiresBootloader = true
388         ),

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:394:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
391             title = "Create NANDroid Backup",
392             description = "Create a full system backup",
393             icon = Icons.Default.Backup,
394             color = Color(0xFF4CAF50),
!!!                           ^ error
395             requiresRoot = true,
396             requiresRecovery = true
397         ),

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:403:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
400             title = "Restore Backup",
401             description = "Restore from a previous backup",
402             icon = Icons.Default.Restore,
403             color = Color(0xFF2196F3),
!!!                           ^ error
404             requiresRoot = true,
405             requiresRecovery = true
406         ),

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:412:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
409             title = "Unlock Bootloader",
410             description = "Unlock device bootloader for modifications",
411             icon = Icons.Default.LockOpen,
412             color = Color(0xFFFFC107),
!!!                           ^ error
413             requiresRoot = false,
414             requiresBootloader = false
415         ),

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:421:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
418             title = "Install Custom Recovery",
419             description = "Install TWRP or other custom recovery",
420             icon = Icons.Default.Healing,
421             color = Color(0xFF9C27B0),
!!!                           ^ error
422             requiresRoot = true,
423             requiresBootloader = true
424         ),

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:430:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
427             title = "Genesis AI Optimizations",
428             description = "Apply AI-powered system optimizations",
429             icon = Icons.Default.Psychology,
430             color = Color(0xFF00E676),
!!!                           ^ error
431             requiresRoot = true,
432             requiresSystem = true
433         )

```

### style, UnusedParameter (3)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:364:35

```
Function parameter `deviceModel` is unused.
```

```kotlin
361 
362 // Placeholder for ROM repository - would be implemented separately
363 class RomRepository {
364     suspend fun getCompatibleRoms(deviceModel: String): List<AvailableRom> {
!!!                                   ^ error
365         // Implementation would query ROM repositories
366         return emptyList()
367     }

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:468:30

```
Function parameter `rom` is unused.
```

```kotlin
465 }
466 
467 @Composable
468 private fun AvailableRomCard(rom: dev.aurakai.auraframefx.romtools.AvailableRom) {
!!!                              ^ error
469     // Implementation for available ROM card
470 }
471 

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:473:24

```
Function parameter `backup` is unused.
```

```kotlin
470 }
471 
472 @Composable
473 private fun BackupCard(backup: dev.aurakai.auraframefx.romtools.BackupInfo) {
!!!                        ^ error
474     // Implementation for backup card
475 }
476 

```

### style, UnusedPrivateProperty (1)

Property is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedprivateproperty)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/RomToolsManager.kt:29:37

```
Private property `context` is unused.
```

```kotlin
26  */
27 @Singleton
28 class RomToolsManager @Inject constructor(
29     @ApplicationContext private val context: Context,
!!                                     ^ error
30     private val bootloaderManager: BootloaderManager,
31     private val recoveryManager: RecoveryManager,
32     private val systemModificationManager: SystemModificationManager,

```

### style, WildcardImport (5)

Wildcard imports should be replaced with imports using fully qualified class names. Wildcard imports
can lead to naming conflicts. A library update can introduce naming clashes with your classes which
results in compilation errors.

[Documentation](https://detekt.dev/docs/rules/style#wildcardimport)

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:4:1

```
androidx.compose.animation.* is a wildcard import. Replace it with fully qualified imports.
```

```kotlin
1 // File: romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt
2 package dev.aurakai.auraframefx.romtools.ui
3 
4 import androidx.compose.animation.*
! ^ error
5 import androidx.compose.foundation.background
6 import androidx.compose.foundation.layout.*
7 import androidx.compose.foundation.lazy.LazyColumn

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:6:1

```
androidx.compose.foundation.layout.* is a wildcard import. Replace it with fully qualified imports.
```

```kotlin
3  
4  import androidx.compose.animation.*
5  import androidx.compose.foundation.background
6  import androidx.compose.foundation.layout.*
!  ^ error
7  import androidx.compose.foundation.lazy.LazyColumn
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:11:1

```
androidx.compose.material.icons.filled.* is a wildcard import. Replace it with fully qualified imports.
```

```kotlin
8  import androidx.compose.foundation.lazy.items
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material.icons.Icons
11 import androidx.compose.material.icons.filled.*
!! ^ error
12 import androidx.compose.material3.*
13 import androidx.compose.runtime.*
14 import androidx.compose.ui.Alignment

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:12:1

```
androidx.compose.material3.* is a wildcard import. Replace it with fully qualified imports.
```

```kotlin
9  import androidx.compose.foundation.shape.RoundedCornerShape
10 import androidx.compose.material.icons.Icons
11 import androidx.compose.material.icons.filled.*
12 import androidx.compose.material3.*
!! ^ error
13 import androidx.compose.runtime.*
14 import androidx.compose.ui.Alignment
15 import androidx.compose.ui.Modifier

```

* romtools/src/main/kotlin/dev/aurakai/auraframefx/romtools/ui/RomToolsScreen.kt:13:1

```
androidx.compose.runtime.* is a wildcard import. Replace it with fully qualified imports.
```

```kotlin
10 import androidx.compose.material.icons.Icons
11 import androidx.compose.material.icons.filled.*
12 import androidx.compose.material3.*
13 import androidx.compose.runtime.*
!! ^ error
14 import androidx.compose.ui.Alignment
15 import androidx.compose.ui.Modifier
16 import androidx.compose.ui.graphics.Color

```

generated with [detekt version 1.23.8](https://detekt.dev/) on 2025-08-26 01:43:33 UTC
