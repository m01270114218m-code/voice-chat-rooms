import 'package:flutter/material.dart';

void main() => runApp(const FarahChatApp());

class FarahChatApp extends StatelessWidget {
  const FarahChatApp({super.key});
  @override
  Widget build(BuildContext context) => MaterialApp(
    debugShowCheckedModeBanner: false,
    title: 'فرح شات',
    theme: ThemeData.dark(useMaterial3: true).copyWith(
      scaffoldBackgroundColor: const Color(0xFF08091A),
      colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFFB45CFF), brightness: Brightness.dark),
    ),
    home: const FarahHome(),
  );
}

class FarahHome extends StatefulWidget {
  const FarahHome({super.key});
  @override State<FarahHome> createState() => _FarahHomeState();
}
class _FarahHomeState extends State<FarahHome> {
  int tab = 0;
  final rooms = const ['Royal Lounge', 'Galaxy Night', 'Diamond Club'];
  @override
  Widget build(BuildContext context) => Scaffold(
    appBar: AppBar(title: const Text('فرح شات'), centerTitle: true),
    body: IndexedStack(index: tab, children: [
      ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: rooms.length,
        itemBuilder: (_, i) => Card(
          child: ListTile(
            leading: const CircleAvatar(child: Icon(Icons.graphic_eq)),
            title: Text(rooms[i]),
            subtitle: const Text('غرفة صوتية • 8 مايكات'),
            trailing: const Icon(Icons.chevron_left),
            onTap: () => Navigator.push(context, MaterialPageRoute(builder: (_) => RoomPage(name: rooms[i]))),
          ),
        ),
      ),
      const Center(child: Text('الأصدقاء')),
      const Center(child: Text('الرسائل')),
      const Center(child: Text('أنا')),
    ]),
    bottomNavigationBar: NavigationBar(
      selectedIndex: tab,
      onDestinationSelected: (v) => setState(() => tab = v),
      destinations: const [
        NavigationDestination(icon: Icon(Icons.home_outlined), label: 'الرئيسية'),
        NavigationDestination(icon: Icon(Icons.people_outline), label: 'الأصدقاء'),
        NavigationDestination(icon: Icon(Icons.chat_bubble_outline), label: 'الرسائل'),
        NavigationDestination(icon: Icon(Icons.person_outline), label: 'أنا'),
      ],
    ),
  );
}

class RoomPage extends StatelessWidget {
  final String name;
  const RoomPage({super.key, required this.name});
  @override
  Widget build(BuildContext context) => Scaffold(
    appBar: AppBar(title: Text(name)),
    body: Column(children: [
      const Padding(
        padding: EdgeInsets.all(12),
        child: Text('غرفة فرح شات • 8 مايكات', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
      ),
      Expanded(
        child: GridView.builder(
          padding: const EdgeInsets.all(16),
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 4, mainAxisSpacing: 18, crossAxisSpacing: 18),
          itemCount: 8,
          itemBuilder: (_, i) => Container(
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              gradient: const LinearGradient(colors: [Color(0xFFB45CFF), Color(0xFF3A1C71)]),
              boxShadow: const [BoxShadow(blurRadius: 14, color: Color(0x553A1C71))],
            ),
            child: const Icon(Icons.mic, color: Colors.white, size: 28),
          ),
        ),
      ),
      Padding(
        padding: const EdgeInsets.all(16),
        child: Row(children: [
          Expanded(child: TextField(decoration: InputDecoration(hintText: 'اكتب رسالة...', border: OutlineInputBorder(borderRadius: BorderRadius.circular(24))))),
          IconButton(onPressed: () {}, icon: const Icon(Icons.card_giftcard)),
        ]),
      ),
    ]),
  );
}
