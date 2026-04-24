export default function StatsCard({ title, value }) {
  return (
    <div className="bg-slate-900 p-6 rounded-2xl border border-slate-800">
      <h3 className="text-slate-400">{title}</h3>
      <p className="text-3xl font-bold mt-3">{value}</p>
    </div>
  );
}