using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btn1_Click(object sender, EventArgs e)
        {
          double x0 = Convert.ToDouble(txtbox1.Text);
          double xk = Convert.ToDouble(txtbox2.Text);
          double dx = Convert.ToDouble(txtbox3.Text);
          double a = Convert.ToDouble(txtbox4.Text);
            

            txtbox5.Text = "Роботу виконав Хаща Василь" + Environment.NewLine;
            double x = x0;
            while (x<=(xk+dx/2))
            {
                x = x + dx;
            }
            double y = x * Math.Sin(Math.Sqrt(x + b - 0.0084));
            txtbox5.Text += "x=" + Convert.ToString(x) + ";" + Environment.NewLine +
                "y=" + Convert.ToString(y) + Environment.NewLine;

        }

        private void txtbox5_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
