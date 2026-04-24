export default function Header() {
  return (
    <header className="h-20 px-8 border-b border-slate-800 bg-slate-900 flex items-center justify-between shadow-sm">

      <div>
        <h2 className="text-2xl font-bold text-white">
          Dashboard
        </h2>
        <p className="text-sm text-slate-400">
            Welcome back, Shrabana!
        </p>
      </div>

      <div className="w-10 h-10 rounded-full bg-sky-500 flex items-center justify-center text-slate-950 font-bold">
        SP
      </div>

    </header>
  );
}